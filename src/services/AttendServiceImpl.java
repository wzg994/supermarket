package services;

import java.util.List;

import beans.StaffAttend;
import dao.StaffAttendDao;
import dao.StaffAttendDaoImpl;

/*
 * 考勤业务逻辑实现类
 */
public class AttendServiceImpl implements AttendService {
	// 加载考勤操作接口
	private StaffAttendDao staffattendDao;
	{
		staffattendDao = new StaffAttendDaoImpl();
	}

	// 考勤信息列表展示
	@Override
	public List<StaffAttend> showAttend() {
		return staffattendDao.getStaffattends();
	}

	// 分页查询考勤信息
	@Override
	public List<StaffAttend> getAttendByPage(String nowpage, String pagesize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pagesize));
		int end = Integer.parseInt(pagesize);

		return staffattendDao.getSatffattendByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pagesize) {
		int total = staffattendDao.getStaffattends().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pagesize)));
		return allpage;
	}

	// 根据员工id获取员工考勤信息
	@Override
	public StaffAttend getAteendById(int id) {
		StaffAttend staffAttend = staffattendDao.getStaffattendById(id);
		return staffAttend;
	}

	// 更新员工考勤信息
	@Override
	public int updateAttend(StaffAttend staffAttend) {
		int out = staffattendDao.updateStaffattend(staffAttend);
		return out;
	}

	// 删除员工考勤信息
	@Override
	public int deleAttend(StaffAttend staffAttend) {
		int out = staffattendDao.deleteStaffattend(staffAttend);
		return out;
	}

	// 新增考勤信息
	@Override
	public int addAttend(StaffAttend staffAttend) {
		int out = staffattendDao.addStaffattend(staffAttend);
		return out;
	}

	// 根据员工姓名查询员工信息
	@Override
	public StaffAttend getAttendByName(String staffname) {
		StaffAttend staffAttend = staffattendDao.getStaffattendByName(staffname);
		return staffAttend;
	}

}
