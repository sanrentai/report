package cn.tst.gongnuan.viewmodel;

import java.util.List;
import cn.tst.gongnuan.entity.RepBiao;
import cn.tst.gongnuan.entity.RepBiaoTiaoJian;

/**
 * 人员分组设置视图模型
 *
 * @author 曹春
 */
public class BaoBiaoGuanLiViewModel extends BaseViewModel {
    
    private RepBiao editingRepBiao;
    
    private RepBiaoTiaoJian editingRepBiaoTiaoJian;
    
    private List<RepBiao> repBiaoList;
    
    private List<RepBiaoTiaoJian> tiaoJianList;

    private RepBiao selectedRepBiao;
    
    public BaoBiaoGuanLiViewModel() {
    }

    public RepBiao getEditingRepBiao() {
        return editingRepBiao;
    }

    public void setEditingRepBiao(RepBiao editingRepBiao) {
        this.editingRepBiao = editingRepBiao;
    }

    public RepBiaoTiaoJian getEditingRepBiaoTiaoJian() {
        return editingRepBiaoTiaoJian;
    }

    public void setEditingRepBiaoTiaoJian(RepBiaoTiaoJian editingRepBiaoTiaoJian) {
        this.editingRepBiaoTiaoJian = editingRepBiaoTiaoJian;
    }

    public List<RepBiao> getRepBiaoList() {
        return repBiaoList;
    }

    public void setRepBiaoList(List<RepBiao> repBiaoList) {
        this.repBiaoList = repBiaoList;
    }

    public List<RepBiaoTiaoJian> getTiaoJianList() {
        return tiaoJianList;
    }

    public void setTiaoJianList(List<RepBiaoTiaoJian> tiaoJianList) {
        this.tiaoJianList = tiaoJianList;
    }

    public RepBiao getSelectedRepBiao() {
        return selectedRepBiao;
    }

    public void setSelectedRepBiao(RepBiao selectedRepBiao) {
        this.selectedRepBiao = selectedRepBiao;
    }

    
}
