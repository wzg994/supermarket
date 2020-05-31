package dao;

import java.util.List;

import beans.StaffAttend;

/*
 * 员工考勤操作接口
 */
public interface StaffAttendDao {

	// 查询员工考勤信息
	public List<StaffAttend> getStaffattends();

	// 分页查询考勤列表
	public List<StaffAttend> getSatffattendByPage(int begin, int end);

	// 根据员工id获取员工考勤信息
	public StaffAttend getStaffattendById(int staffid);

	// 根据员工名称获取员工考勤信息
	public StaffAttend getStaffattendByName(String staffname);

	// 根据员工id查询员工考勤信息
	public List<StaffAttend> selectStaffattend(StaffAttend staffAttend);

	// 添加考勤信息
	public int addStaffattend(StaffAttend staffAttend);

	// 更新考勤信息
	public int updateStaffattend(StaffAttend staffAttend);

	// 删除考勤信息
	public int deleteStaffattend(StaffAttend staffAttend);
}
