package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.entity.RepBiaoTiaoJian;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * 表Facade实现类
 *
 * @author 曹春
 */
@Stateless
public class RepBiaoTiaoJianFacade extends AbstractFacade<RepBiaoTiaoJian> {

    public RepBiaoTiaoJianFacade() {
        super(RepBiaoTiaoJian.class);
    }

    /**
     * 删除表的全部条件
     *
     * @param biaoId 表ID
     */
    public void removeAllTiaoJianByBiao(int biaoId) {
        Query q = getEntityManager().createQuery("DELETE FROM RepBiaoTiaoJian as r WHERE r.biaoId = :biaoId");
        q.setParameter("biaoId", biaoId);
        q.executeUpdate();
    }

}
