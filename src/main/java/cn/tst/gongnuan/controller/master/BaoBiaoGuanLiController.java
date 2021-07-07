package cn.tst.gongnuan.controller.master;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import cn.tst.gongnuan.common.SepC;
import cn.tst.gongnuan.common.SepE;
import cn.tst.gongnuan.controller.BusinessBaseController;
import cn.tst.gongnuan.viewmodel.ExecuteResult;
import cn.tst.gongnuan.viewmodel.BaoBiaoGuanLiViewModel;
import org.apache.log4j.Logger;
import cn.tst.gongnuan.bizlogic.BaoBiaoGuanLiBizLogic;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.entity.RepBiaoTiaoJian;
import java.util.ArrayList;

/**
 * 报表管理
 *
 * @author 曹春
 */
@ViewScoped
@Named(SepC.ControllerID.BAO_BIAO_GUAN_LI)
public class BaoBiaoGuanLiController extends BusinessBaseController {

    private static final Logger LOG = Logger.getLogger(BaoBiaoGuanLiController.class.getName());
    private BaoBiaoGuanLiViewModel vm;

    private int t;

    @EJB
    private BaoBiaoGuanLiBizLogic bizLogic;

    @PostConstruct
    public void init() {
        ///初始化视图模型
        this.vm = new BaoBiaoGuanLiViewModel();
        t = 0;
        this.bizLogic.loadrenYuanFenZuSheZhiViewModel(vm);
    }

    /**
     * 添加报表
     */
    public void addBaoBiao() {
        vm.setEditingRepBiao(new RepBiao());
        vm.setTiaoJianList(new ArrayList<>());
    }

    /**
     * 添加条件
     */
    public void addTiaoJian() {
        if (vm.getEditingRepBiaoTiaoJian() == null) {
            vm.setEditingRepBiaoTiaoJian(new RepBiaoTiaoJian(t++));
        } else {
            vm.getTiaoJianList().add(vm.getEditingRepBiaoTiaoJian());
            vm.setEditingRepBiaoTiaoJian(new RepBiaoTiaoJian(t++));
        }
    }

    /**
     * 保存分组
     */
    public void onSave() {

        SepE.ExecuteMode mode = this.vm.getEditingRepBiao().getId() == null
                ? SepE.ExecuteMode.INSERT : SepE.ExecuteMode.UPDATE;

        ///执行更新
        ExecuteResult result = this.bizLogic.saveRepBiao(mode, vm);

        this.addMessage(result.createMessage());

        if (result.isSuccess()) {
            onCancelEditing();
        }
    }

    /**
     * 取消编辑
     */
    public void onCancelEditing() {
        this.vm.setEditingRepBiao(null);
        vm.setTiaoJianList(null);
        onRefreshData();
    }

    /**
     * 编辑报表
     *
     * @param row 选中的行
     */
    public void onEditRepBiao(RepBiao row) {
        vm.setEditingRepBiao(row);
        vm.setTiaoJianList(row.getTiaoJianList());
    }

    /**
     * 编辑条件
     *
     * @param row 选中的行
     */
    public void onEditTiaoJian(RepBiaoTiaoJian row) {
        vm.setEditingRepBiaoTiaoJian(row);
    }

    /**
     * 移除条件
     *
     * @param row 选中的行
     */
    public void onRemoveTiaoJian(RepBiaoTiaoJian row) {
        vm.getTiaoJianList().remove(row);
    }

    /**
     * 选择分组
     *
     * @param row
     */
    public void setSelectedRepBiao(RepBiao row) {
        ///设置编辑的对象
        vm.setSelectedRepBiao(row);
    }

    public void onDeleteRepBiao(RepBiao row) {
        ///删除模式
        SepE.ExecuteMode mode = SepE.ExecuteMode.DELETE;
        vm.setEditingRepBiao(row);

        ///执行更新
        ExecuteResult result = this.bizLogic.saveRepBiao(mode, vm);

        if (result.isSuccess()) {
            putInfoMessage("删除成功");

            onCancelEditing();
        } else {
            putErrorMessage("删除失败");
        }
    }

    /**
     * 刷新数据
     */
    public void onRefreshData() {
        bizLogic.refresh(vm);
    }

    public BaoBiaoGuanLiViewModel getVm() {
        return vm;
    }

    public void setVm(BaoBiaoGuanLiViewModel vm) {
        this.vm = vm;
    }

}
