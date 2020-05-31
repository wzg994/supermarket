package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.StaffAttend;
import util.JDBCUtil;

/*
 * Ա�����ڲ����ӿ�ʵ����
 */
public class StaffAttendDaoImpl implements StaffAttendDao {

	// ��ѯԱ����Ϣ�б�
	@Override
	public List<StaffAttend> getStaffattends() {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend ";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				StaffAttend staffAttend = new StaffAttend();

				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// ��staffAttend������뵽���ϵ���
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// ��ҳ��ѯԱ������Ϣ
	@Override
	public List<StaffAttend> getSatffattendByPage(int begin, int end) {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				StaffAttend staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// ��staffAttend������뵽���ϵ���
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// ����Ա��id��ѯ������Ϣ
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
			// ���������
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

	// ����Ա��id��ѯ������Ϣ�б�
	@Override
	public List<StaffAttend> selectStaffattend(StaffAttend staffAttend) {
		List<StaffAttend> staffAttends = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// ��ʼ������
			staffAttends = new ArrayList<StaffAttend>();
			String sql = "SELECT * FROM staffattend WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffAttend.getStaffid());
			rs = ps.executeQuery();
			// ���������
			while (rs.next()) {
				staffAttend = new StaffAttend();
				staffAttend.setStaffid(rs.getInt("staffid"));
				staffAttend.setStaffname(rs.getString("staffname"));
				staffAttend.setStafftime(rs.getDate("stafftime"));
				staffAttend.setAttendtime(rs.getInt("attendtime"));
				staffAttend.setMark(rs.getString("mark"));
				// ��staffAttend������뵽���ϵ���
				staffAttends.add(staffAttend);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffAttends;
	}

	// �޸Ŀ�����Ϣ
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

	// ɾ��������Ϣ
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

	// ����������Ϣ
	@Override
	public int addStaffattend(StaffAttend staffAttend) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO staffattend(staffid,staffname,stafftime,attendtime,mark) VALUES(?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
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

	// ����Ա�����Ʋ�ѯ������Ϣ
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
			// ���������
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
