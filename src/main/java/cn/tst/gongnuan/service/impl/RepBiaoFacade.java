package cn.tst.gongnuan.service.impl;

import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.entity.RepBiao;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * 表Facade实现类
 *
 * @author 曹春
 */
@Stateless
public class RepBiaoFacade extends AbstractFacade<RepBiao> {

    public RepBiaoFacade() {
        super(RepBiao.class);
    }

    public RepBiao findByBiaoMing(String menuItemId) {
        Query q = this.getEntityManager().createNamedQuery("RepBiao.findByBiaoMing");
        q.setParameter("biaoMing", menuItemId);
        q.setParameter("delFlg", SepE.Flag.NO.getValue());
        return (RepBiao)q.getSingleResult();
    }

}
