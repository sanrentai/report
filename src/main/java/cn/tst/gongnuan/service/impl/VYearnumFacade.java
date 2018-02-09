/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.tst.gongnuan.service.impl;

import javax.ejb.Stateless;
import cn.tst.gongnuan.entity.VYearnum;
import java.util.List;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author 曹春
 */
@Stateless
public class VYearnumFacade extends AbsFacade<VYearnum> {

    private static final Logger LOG = Logger.getLogger(VYearnum.class.getName());

    public VYearnumFacade() {
        super(VYearnum.class);
    }

}
