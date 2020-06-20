package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.common.CConst;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.controller.login.AccountManager;
import cn.tst.gongnuan.entity.BaseEntity;
import java.util.List;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;

/**
 * 持久化访问抽象类
 *
 * @author ps_xy@pscp.co.jp
 * @param <T>
 */
//@Interceptors(AbstractFacadeInterceptor.class)
public abstract class AbstractFacade<T extends BaseEntity> {

    @Inject
    private AccountManager am;

    private final Class<T> entityClass;

    @ExcludeClassInterceptors
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = SepC.PERSISTENCE_UNIT)
    private EntityManager em2;

    public EntityManager getEntityManager() {
        return em2;
    }

    /**
     * 将数据插入db
     *
     * @param entity
     * @return
     */
    public T create(T entity) {
        EntityManager em = getEntityManager();
        entity.setCreateInfo(am.getEmployee().getEmpId());
        System.out.println("create  "+entity);
        em.persist(entity);
        em.flush();
        return (T) keyIdReset(entity);
    }

    /**
     * 批量插入DB
     *
     * @param list list
     * @return
     */
    public List createList(List<T> list) {
        EntityManager em = getEntityManager();
        for (T e : list) {
            e.setCreateInfo(am.getEmployee().getEmpId());
            em.persist(e);
//            em.flush();
//            em.refresh(e);
        }
//        em.flush();
//        em.clear();
        return list;
    }

    /**
     * 修改
     *
     * @param entity
     */
    public T edit(T entity) {
        EntityManager em = getEntityManager();
        entity.setUpdateInfo(am.getEmployee().getEmpId());
        entity = em.merge(entity);
//        em.flush();
//        em.clear();
//        em.flush();
//        em.refresh(entity);
        return entity;
    }

    /**
     * 更新数据后返回更新的对象
     *
     * @param entity
     * @return
     */
    public T merge(T entity) {
        EntityManager em = getEntityManager();
        entity.setUpdateInfo(am.getEmployee().getEmpId());
        entity = em.merge(entity);
//        em.flush();
//        em.clear();
//        em.refresh(entity);
//        em.flush();
        return entity;
    }

    /**
     * 批量修改
     *
     * @param list
     * @return
     */
    public List editList(List<T> list) {
        EntityManager em = getEntityManager();
        for (T e : list) {
            merge(e);
        }
        return list;
    }

    /**
     * 从db中删除记录（理论删除�?
     *
     * @param entity
     */
    public void remove(T entity) {
        EntityManager em = getEntityManager();
        if (entity.getDelFlg().equals(SepE.Flag.NO)) {
            /// 删除flag为false时，将删除flag置为true
            entity.setDelFlg(SepE.Flag.YES);
            edit(entity);
//        } else {
//            /// 删除flag为true时，将这条记录删�?
//            em.remove(em.merge(entity));
        }
//        em.flush();
//        em.clear();
    }

    /**
     * 批量从db中删除记录（理论删除�?
     *
     * @param entityList
     */
    public void removeList(List<T> entityList) {
        EntityManager em = getEntityManager();
        for (T e : entityList) {
            remove(e);
        }
    }

    /**
     * 从db中删除记录（物理删除�?
     *
     * @param entity
     */
    public void forceRemove(T entity) {
        EntityManager em = getEntityManager();
        /// 将这条记录删�?
        if (!em.contains(entity)) {
            entity = em.merge(entity);
        }
        em.remove(entity);
//        em.flush();
//        em.clear();
    }

    /**
     * 批量从db中删除记录（物理删除�?
     *
     * @param entityList
     */
    public void forceRemoveList(List<T> entityList) {
        EntityManager em = getEntityManager();
        for (T e : entityList) {
            forceRemove(e);
        }
    }

    /**
     * 刷新记录
     *
     * @param e
     * @return
     */
    public T refresh(T e) {
        EntityManager em = getEntityManager();
        em.refresh(e);
        return e;
    }

    public T find(Object id) {
        EntityManager em = getEntityManager();
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(entityClass);
        Root c = q.from(entityClass);
        q.select(c);
        q.where(cb.equal(c.get("delFlg"), SepE.Flag.NO.getValue()));
//        q.orderBy(cb.desc(c.get(BaseEntity_.updDate)));
        Query query = em.createQuery(q);
        return query.getResultList();
    }

    public List<T> findRange(int[] range) {
        EntityManager em = getEntityManager();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        EntityManager em = getEntityManager();
        javax.persistence.criteria.CriteriaBuilder builder = em.getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery cq = builder.createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        cq.where(builder.equal(rt.get("delFlg"), SepE.Flag.NO.getValue()));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    /**
     * 自動プライマリキーを生成するエンティティ―が永久化直後にこのメソッドを呼び出し�??<br />
     * DBに自動生成されたプロマリキ�?�をエンティティ―オブジェクトに設定する�?
     *
     * @param em
     * @param entityObj
     * @return
     */
    @ExcludeClassInterceptors
    private Object keyIdReset(Object entityObj) {
        EntityManager em = getEntityManager();

        if (entityObj == null) {
            return null;
        }

        // オリジナルエンティティ�?�に初期化する�??
        Object resultObj = entityObj;

        // エンティティ―クラス名の取得
//        String[] pkAry = entityObj.getClass().getName().split("\\.");
//        String entityClassName = pkAry[pkAry.length - 1];
        // 汎用キーID
        Object keyId = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entityObj);

        resultObj = em.find(entityObj.getClass(), keyId);

        return resultObj;
    }
}
