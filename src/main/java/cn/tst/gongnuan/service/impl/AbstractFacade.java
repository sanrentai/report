package cn.tst.gongnuan.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import cn.tst.gongnuan.common.CConst;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.controller.login.AccountManager;
import org.apache.commons.lang3.StringUtils;

/**
 * 持久化访问抽象类
 *
 * @author ps_xy@pscp.co.jp
 * @param <T>
 */
//@Interceptors(AbstractFacadeInterceptor.class)
public abstract class AbstractFacade<T> {

    @Inject
    private AccountManager am;

    private final Class<T> entityClass;

    @ExcludeClassInterceptors
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = SepC.PERSISTENCE_UNIT)
    private EntityManager em1;


    public EntityManager getEntityManager() {
        return em1;
    }

    public List<T> findAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(entityClass);
        Root c = q.from(entityClass);
        q.select(c);
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
    
    public void create(T entity) {
        EntityManager em = getEntityManager();
        em.persist(entity);
        em.flush();
//        em.clear();
//        return (T) keyIdReset(entity);
    }
    public T edit(T entity) {
        EntityManager em = getEntityManager();
        entity = em.merge(entity);
        return entity;
    }
    
    public void remove(T entity) {
        EntityManager em = getEntityManager();
        /// 将这条记录删除
        em.remove(em.merge(entity));
    }
}
