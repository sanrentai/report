package cn.tst.gongnuan.viewmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.tst.gongnuan.entity.Employee;

/**
 * 违章登记视图模型
 *
 * @author 曹春
 */
public class MST0001ViewModel extends BaseViewModel {

    
    ///编辑中的系统用户
    private Employee editingEmployee;

    ///车辆违章一览
    private List<Employee> employeeList;

    public MST0001ViewModel() {
    }

    public Employee getEditingEmployee() {
        return editingEmployee;
    }

    public void setEditingEmployee(Employee editingEmployee) {
        this.editingEmployee = editingEmployee;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
