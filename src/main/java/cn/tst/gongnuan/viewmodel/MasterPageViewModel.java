package cn.tst.gongnuan.viewmodel;

import java.util.List;
import cn.tst.gongnuan.entity.GroupMenu;

/**
 * 模板页务数据模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class MasterPageViewModel {

    List<GroupMenu> groupMenuList;

    public MasterPageViewModel() {

    }

    public List<GroupMenu> getGroupMenuList() {
        return groupMenuList;
    }

    public void setGroupMenuList(List<GroupMenu> groupMenuList) {
        this.groupMenuList = groupMenuList;
    }
}
