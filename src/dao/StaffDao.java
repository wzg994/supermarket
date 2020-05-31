package dao;

import java.util.List;

import beans.Staff;

/*
 * 员工操作接口
 */
public interface StaffDao {

	// 查询员工列表
	public List<Staff> getStaff();

	// 查询员工
	public Staff selectStaff(String staffname, String password);

	// 根据员工id查询员工信息
	public Staff getStaffById(String staffid);

	// 分页查询员工信息
	public List<Staff> getStaffByPage(int begin, int end);

	// 根据员工id查询员工信息列表
	public List<Staff> selcetStaff(Staff staff);

	// 查询员工名
	public String selectStaffName(String staffname);

	// 添加员工
	public int addStaff(Staff staff);

	// 修改员工
	public int updateStaff(Staff staff);

	// 删除员工
	public int deleStaff(Staff staff);

	// 根据员工名字查询员工
	public Staff getStaffByName(String staffname);

	// 根据员工名字模糊查询员工列表
	public List<Staff> selectStaffByName(String staffname);

}
