package services;

import java.util.List;

import beans.Staff;
import dao.StaffDao;
import dao.StaffDaoImpl;

/*
 * 员工业务逻辑实现类
 */
public class StaffServiceImpl implements StaffService {
	// 加载员工操作接口
	private StaffDao staffDao;
	{
		staffDao = new StaffDaoImpl();
	}

	// 员工信息展示
	@Override
	public List<Staff> showStaffs() {
		return staffDao.getStaff();
	}

	// 员工信息删除
	@Override
	public int deleStaff(Staff staff) {
		int out = staffDao.deleStaff(staff);
		return out;
	}

	// 员工注册
	@Override
	public int regstaff(Staff staff) {
		int out = 0;
		// 查询员工名称
		String staffname = staffDao.selectStaffName(staff.getStaffname());
		// 判断员工名称是否存在，如果员工名称存在则返回0，不存在则创建新员工
		if (staffname != null) {
			out = 0;
		} else {
			out = staffDao.addStaff(staff);
		}
		return out;
	}

	// 员工登录
	@Override
	public Staff logstaff(String staffname, String staffpassword) {
		Staff staff = staffDao.selectStaff(staffname, staffpassword);
		return staff;
	}

	// 分页查询
	@Override
	public List<Staff> getStaffByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return staffDao.getStaffByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = staffDao.getStaff().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 新增员工
	@Override
	public int addStaff(Staff staff) {
		int out = staffDao.addStaff(staff);
		return out;
	}

	// 修改员工密码
	@Override
	public int updatePassword(Staff staff) {
		int out = staffDao.updateStaff(staff);
		return out;
	}

	// 验证账号
	@Override
	public boolean existName(String staffname) {
		Staff staff = staffDao.getStaffByName(staffname);
		if (staff != null)
			return true;
		return false;
	}

	// 根据员工姓名查询员工
	@Override
	public List<Staff> selectStaffByName(String staffname) {
		List<Staff> selectStaffByName = staffDao.selectStaffByName(staffname);
		return selectStaffByName;
	}

	// 修改员工信息
	@Override
	public int updateStaff(Staff staff) {
		int out = staffDao.updateStaff(staff);
		return out;
	}

	// 根据员工id查询员工信息
	@Override
	public Staff getStaffById(String staffid) {
		Staff staffById = staffDao.getStaffById(staffid);
		return staffById;
	}

	// 根据员工姓名模糊查询员工
	@Override
	public Staff getStaffByName(String staffname) {
		Staff staffByName = staffDao.getStaffByName(staffname);
		return staffByName;
	}

}
