package cn.tst.gongnuan.viewmodel;

import java.util.List;
import cn.tst.gongnuan.entity.GroupMenu;
import cn.tst.gongnuan.entity.RepBiao;

/**
 * 模板页务数据模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class MasterPageViewModel {

    List<GroupMenu> groupMenuList;

    List<RepBiao> biaoList;

    public MasterPageViewModel() {

    }

    public List<GroupMenu> getGroupMenuList() {
        return groupMenuList;
    }

    public void setGroupMenuList(List<GroupMenu> groupMenuList) {
        this.groupMenuList = groupMenuList;
    }

    public List<RepBiao> getBiaoList() {
        return biaoList;
    }

    public void setBiaoList(List<RepBiao> biaoList) {
        this.biaoList = biaoList;
    }
}
