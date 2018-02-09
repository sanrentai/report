package cn.tst.gongnuan.bizlogic.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.viewmodel.ExecuteResult;
import cn.tst.gongnuan.viewmodel.BaoBiaoGuanLiViewModel;
import cn.tst.gongnuan.bizlogic.BaoBiaoGuanLiBizLogic;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.entity.RepBiaoTiaoJian;
import cn.tst.gongnuan.service.impl.RepBiaoFacade;
import cn.tst.gongnuan.service.impl.RepBiaoTiaoJianFacade;

/**
 * 人员分组设置
 *
 * @author 曹春
 */
@Stateless
public class BaoBiaoGuanLiBizLogicImpl extends BaseBizLogic implements BaoBiaoGuanLiBizLogic {

    private final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(BaoBiaoGuanLiBizLogicImpl.class);

    @EJB
    private RepBiaoFacade biaoDao;

    @EJB
    private RepBiaoTiaoJianFacade biaoTiaoJianDao;

    @Override
    public void loadrenYuanFenZuSheZhiViewModel(BaoBiaoGuanLiViewModel vm) {
        refresh(vm);
        List<RepBiao> repBiaoList = biaoDao.findAll();
        vm.setRepBiaoList(repBiaoList);
        /// 所有用户
//        List<Employee> employeeList = employeeDao.findAll();
//        vm.setEmployeeList(employeeList);
    }

    @Override
    public void refresh(BaoBiaoGuanLiViewModel vm) {
//        List<CcFenZu> fenZuList = fenZuDao.findAll();
//        vm.setFenZuList(fenZuList);
//        if (vm.getSelectedFenZu() != null) {
//            CcFenZu fenZu = fenZuDao.find(vm.getSelectedFenZu().getId());
//            vm.setSelectedFenZu(fenZu);
//        }
//        List<Building> daLouList = daLouDao.findAll();
//        vm.setDaLouList(daLouList);
    }

    @Override
    public ExecuteResult saveRepBiao(SepE.ExecuteMode mode, BaoBiaoGuanLiViewModel vm) {

        ExecuteResult result = new ExecuteResult(mode);

        try {

            RepBiao target = vm.getEditingRepBiao();
            List<RepBiaoTiaoJian> tiaoJianList = vm.getTiaoJianList();
            switch (mode) {
                case INSERT:
                    target = biaoDao.create(target);
                    for (RepBiaoTiaoJian tj : tiaoJianList) {
                        tj.setBiaoId(target.getId());
                        tj.setId(null);
                        biaoTiaoJianDao.create(tj);
                    }
                    break;
                case UPDATE:
                    biaoTiaoJianDao.removeAllTiaoJianByBiao(target.getId());
                    for (RepBiaoTiaoJian tj : tiaoJianList) {
                        tj.setBiaoId(target.getId());
                        tj.setId(null);
                        biaoTiaoJianDao.create(tj);
                    }
                    biaoDao.edit(target);

                    break;
                case DELETE:
                    biaoTiaoJianDao.removeAllTiaoJianByBiao(target.getId());
                    biaoDao.forceRemove(target);
                    break;
            }
            refresh(vm);
            result.setSuccess(true);
        } catch (Exception e) {
            result.anylizeException(e);
            result.setSuccess(false);
            e.printStackTrace();
            LOG.error(e);
        }
        return result;
    }

}
