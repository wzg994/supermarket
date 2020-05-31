package services;

import java.util.List;

import beans.StaffAttend;
/*
 * 考勤业务逻辑层接口
 */
public interface AttendService {
	// 考勤信息列表展示
	public List<StaffAttend> showAttend();

	// 分页查询考勤信息
	public List<StaffAttend> getAttendByPage(String nowpage, String pagesize);

	// 获取总页数
	public int getAllpage(String pagesize);

	// 根据员工姓名获取员工考勤信息
	public StaffAttend getAttendByName(String staffname);

	// 添加考勤信息
	public int addAttend(StaffAttend staffAttend);

	// 根据员工id获取商品
	public StaffAttend getAteendById(int id);

	// 修改考勤信息
	public int updateAttend(StaffAttend staffAttend);

	// 删除考勤信息
	public int deleAttend(StaffAttend staffAttend);

}
