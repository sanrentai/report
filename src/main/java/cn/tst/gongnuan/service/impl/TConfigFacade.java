package cn.tst.gongnuan.service.impl;

import javax.ejb.Stateless;
import cn.tst.gongnuan.entity.TConfig;
import org.apache.log4j.Logger;

/**
 * 系统配置
 *
 * @author 曹春
 */
@Stateless
public class TConfigFacade extends AbstractFacade<TConfig> {

    private static final Logger LOG = Logger.getLogger(TConfig.class.getName());

    public TConfigFacade() {
        super(TConfig.class);
    }

}