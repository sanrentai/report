package cn.tst.gongnuan.viewmodel;

import cn.tst.gongnuan.common.CConst;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 * 系统配置视图模型
 *
 * @author ps_xy@pscp.co.jp
 */
public class SystemConfigViewModel {

    ///菜单展开状�?�控�?
    private boolean silmMenu;
    private String color = "Blue";
    private String title = "报表系统";

    private String yearnum;
    private Date starDate;
    private Date endDate;

    public String getYearnum() {
        return yearnum;
    }

    public void setYearnum(String yearnum) {
        this.yearnum = yearnum;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    

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
     * @return 菜单类型字符�?
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
