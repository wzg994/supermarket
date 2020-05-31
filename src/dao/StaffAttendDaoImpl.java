package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StaffAttend;
import util.JDBCUtil;

/*
 * 员工考勤操作接口实现类
 */
public class StaffAttendDaoImpl implements StaffAttendDao {

	// 查询员工信息列表
	@Override
	public List<StaffAttend> getStaffattends() {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 初始化集合
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend ";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				StaffAttend staffAttend = new StaffAttend();

				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// 把staffAttend对象加入到集合当中
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// 分页查询员考勤信息
	@Override
	public List<StaffAttend> getSatffattendByPage(int begin, int end) {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 初始化集合
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				StaffAttend staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// 把staffAttend对象加入到集合当中
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// 根据员工id查询考勤信息
	@Override
	public StaffAttend getStaffattendById(int staffid) {
		StaffAttend staffAttend = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staffattend WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffid);
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttend;
	}

	// 根据员工id查询考勤信息列表
	@Override
	public List<StaffAttend> selectStaffattend(StaffAttend staffAttend) {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 初始化集合
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffAttend.getStaffid());
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// 把staffAttend对象加入到集合当中
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// 修改考勤信息
	@Override
	public int updateStaffattend(StaffAttend staffAttend) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE staffattend SET staffname=?,stafftime=?,attendtime=?,mark=? WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, staffAttend.getStaffname());
			ps.setObject(2, staffAttend.getStafftime());
			ps.setObject(3, staffAttend.getAttendtime());
			ps.setObject(4, staffAttend.getMark());
			ps.setObject(5, staffAttend.getStaffid());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 删除考勤信息
	@Override
	public int deleteStaffattend(StaffAttend staffAttend) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM staffattend WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffAttend.getStaffid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 新增考勤信息
	@Override
	public int addStaffattend(StaffAttend staffAttend) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO staffattend(staffid,staffname,stafftime,attendtime,mark) VALUES(?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, staffAttend.getStaffid());
			ps.setObject(2, staffAttend.getStaffname());
			ps.setObject(3, staffAttend.getStafftime());
			ps.setObject(4, staffAttend.getAttendtime());
			ps.setObject(5, staffAttend.getMark());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 根据员工名称查询考勤信息
	@Override
	public StaffAttend getStaffattendByName(String staffname) {
		StaffAttend staffAttend = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staffattend WHERE staffname=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffname);
			rs = ps.executeQuery();
			// 遍历结果集
			while (rs.next()) {
				staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttend;
	}

}
