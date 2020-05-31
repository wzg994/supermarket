package services;

import java.util.List;

import beans.Staff;

/*
 * 员工业务逻辑层接口
 */
public interface StaffService {

	// 员工信息展示
	public List<Staff> showStaffs();

	// 根据员工id查询员工信息
	public Staff getStaffById(String staffid);

	// 分页查询
	public List<Staff> getStaffByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 员工信息删除
	public int deleStaff(Staff staff);

	// 员工信息删除
	public int updateStaff(Staff staff);

	// 新增员工
	public int addStaff(Staff staff);

	// 员工注册
	public int regstaff(Staff staff);

	// 员工登录
	public Staff logstaff(String staffname, String staffpassword);

	// 修改员工密码
	public int updatePassword(Staff staff);

	// 验证账号
	public boolean existName(String staffname);

	// 根据员工姓名查询员工
	public Staff getStaffByName(String staffname);

	// 根据员工姓名模糊查询员工
	public List<Staff> selectStaffByName(String staffname);
}
