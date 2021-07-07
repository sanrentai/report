package cn.tst.gongnuan.controller.master;

import org.apache.log4j.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.BaoBiaoViewModel;
import java.util.Date;
import cn.tst.gongnuan.bizlogic.BaoBiaoBizLogic;
import cn.tst.gongnuan.entity.RepBiao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.StreamedContent;

/**
 * 物资信息查看
 *
 * @author CaoChun
 */
@ViewScoped
@Named(SepC.ControllerID.BAO_BIAO)
public class BaoBiaoController extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(BaoBiaoController.class.getName());

    @EJB
    private BaoBiaoBizLogic bizLogic;

    /**
     * 物资信息查看视图模型
     */
    private BaoBiaoViewModel vm;

    @PostConstruct
    public void init() {
        vm = new BaoBiaoViewModel();
        vm.setTjMap(new HashMap());
        vm.setStartDate(new Date());
        vm.setEndDate(new Date());
        bizLogic.loadBaoBiaoViewModel(vm);
    }

    public StreamedContent daoChuExcel() {
        LOG.info("导出");
        bizLogic.daoChuExcel(vm);
        return vm.getWordfile();
    }

    public RepBiao huoQuBaoBiao(String biaoMing) {

        return bizLogic.huoQuBaoBiao(biaoMing);
    }

    public void heJi() {

    }

    public List<Map<String, Object>> chaMeiJuList(String sql, String gl) {
        LOG.info(gl);
//        LOG.info(sql);
        List<Map<String, Object>> chaMeiJu;
        if (StringUtils.isEmpty(gl)) {
            chaMeiJu = bizLogic.chaMeiJu(sql);
        } else {
            chaMeiJu = bizLogic.chaMeiJuByTiaoJian(sql, gl, vm);
        }
//        LOG.info(chaMeiJu);
        return chaMeiJu;
    }

    public void chaXun(String biaoMing) {
        RepBiao huoQuBaoBiao = huoQuBaoBiao(biaoMing);
        vm.setBiao(huoQuBaoBiao);
//        for (RepBiaoTiaoJian tj : huoQuBaoBiao.getDateTiaoJianList()) {
//            LOG.info((Date)vm.getTjMap().get(tj.getTitle()));
//        }
//        LOG.info(vm.getTjMap());
        bizLogic.chaXun(vm);
//        heJi();
    }

    //*****************************************************************
    //                        Getter Setter
    //*****************************************************************
    public BaoBiaoViewModel getVm() {
        return vm;
    }

    public void setVm(BaoBiaoViewModel vm) {
        this.vm = vm;
    }

}
