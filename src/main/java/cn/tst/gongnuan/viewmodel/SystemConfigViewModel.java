package cn.tst.gongnuan.viewmodel;

import java.util.List;
import java.util.stream.Collectors;
import cn.tst.gongnuan.common.CConst;
//import cn.tst.gongnuan.entity.MstLeiBieGuanLi;
//import cn.tst.gongnuan.entity.MstSystemConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统配置视图模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class SystemConfigViewModel {

    ///菜单展开状态控制
    private boolean silmMenu;
    private String color = "Blue";
    private String title = "报表系统";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSilmMenu() {
        return silmMenu;
    }

    public void setSilmMenu(boolean silmMenu) {
        this.silmMenu = silmMenu;
    }



    /**
     * 系统颜色
     *
     * @return 返回系统颜色
     *
     */
    private String getTopBarColor() {
        return this.getColor() + "Topbar";
    }

    /**
     * 菜单类型
     *
     * @return 菜单类型字符串
     */
    private String getMenuType() {
        return this.silmMenu ? "SlimMenu" : "";
    }

    /**
     * 顶部菜单样式
     *
     * @return TopBar 样式
     */
    public String getTopBarStyle() {
        return StringUtils.join(new String[]{
            this.getTopBarColor(),
            this.getMenuType()
        }, CConst.SPACE);
    }
    
    
}
