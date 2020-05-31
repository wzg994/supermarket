package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Staff;
import util.JDBCUtil;

/*
 * Ա�������ӿ�ʵ����
 */
public class StaffDaoImpl implements StaffDao {

	// ��ѯԱ���б�
	@Override
	public List<Staff> getStaff() {
		List<Staff> staffs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			staffs = new ArrayList<Staff>();
			String sql = "SELECT * FROM staff";
			ps = JDBCUtil.getPs(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));

				staffs.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffs;
	}

	// ���Ա��
	@Override
	public int addStaff(Staff staff) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO staff(staffid,staffname,idnum,sex,tel,staffadd,staffedu,staffpassword) VALUES(?,?,?,?,?,?,?,?)";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, staff.getStaffid());
			ps.setObject(2, staff.getStaffname());
			ps.setObject(3, staff.getIdnum());
			ps.setObject(4, staff.getSex());
			ps.setObject(5, staff.getTel());
			ps.setObject(6, staff.getStaffadd());
			ps.setObject(7, staff.getStaffedu());
			ps.setObject(8, staff.getStaffpassword());

			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ɾ��Ա��
	@Override
	public int deleStaff(Staff staff) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM staff where staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staff.getStaffid());
			out = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ��ѯԱ��
	@Override
	public Staff selectStaff(String staffname, String password) {
		Staff staff = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staff where staffname=? AND staffpassword=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffname);
			ps.setObject(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staff;
	}

	// ����Ա��������ѯԱ����Ϣ
	@Override
	public String selectStaffName(String staffname) {
		String name = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staff where staffname=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffname);
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("staffname");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return name;
	}

	// ��ҳ��ѯԱ����Ϣ
	@Override
	public List<Staff> getStaffByPage(int begin, int end) {
		List<Staff> staffs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			staffs = new ArrayList<Staff>();
			String sql = "SELECT * FROM staff LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, begin);
			ps.setObject(2, end);
			rs = ps.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));

				staffs.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffs;
	}

	// �޸�Ա����Ϣ
	@Override
	public int updateStaff(Staff staff) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE staff SET staffname=?,idnum=?,sex=?,tel=?,staffadd=?,staffedu=?,staffpassword=? WHERE staffid=?";
			ps = JDBCUtil.getPs(sql);

			ps.setObject(1, staff.getStaffname());
			ps.setObject(2, staff.getIdnum());
			ps.setObject(3, staff.getSex());
			ps.setObject(4, staff.getTel());
			ps.setObject(5, staff.getStaffadd());
			ps.setObject(6, staff.getStaffedu());
			ps.setObject(7, staff.getStaffpassword());
			ps.setObject(8, staff.getStaffid());

			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ����Ա��id��ѯԱ����Ϣ
	@Override
	public Staff getStaffById(String staffid) {
		Staff staff = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staff where staffid=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staffid);
			rs = ps.executeQuery();
			while (rs.next()) {
				staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staff;
	}

	// ����Ա��id��ѯԱ����Ϣ�б�
	@Override
	public List<Staff> selcetStaff(Staff staff) {
		List<Staff> staffs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			staffs = new ArrayList<Staff>();
			String sql = "SELECT * FROM staff WHERE staffid=? OR staffname=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, staff.getStaffid());
			ps.setObject(2, staff.getStaffname());
			rs = ps.executeQuery();
			while (rs.next()) {
				staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));

				staffs.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffs;
	}

	// ����Ա�����Ʋ�ѯԱ��
	@Override
	public Staff getStaffByName(String staffname) {
		Staff staff = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM staff where staffname=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, staffname);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staff;
	}

	// ����Ա������ģ����ѯԱ����Ϣ
	@Override
	public List<Staff> selectStaffByName(String staffname) {
		List<Staff> staffs = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			staffs = new ArrayList<Staff>();
			String sql = "SELECT * FROM staff WHERE staffname LIKE ?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, "%" + staffname + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffid(rs.getString("staffid"));
				staff.setStaffname(rs.getString("staffname"));
				staff.setIdnum(rs.getString("idnum"));
				staff.setSex(rs.getString("sex"));
				staff.setTel(rs.getString("tel"));
				staff.setStaffadd(rs.getString("staffadd"));
				staff.setStaffedu(rs.getString("staffedu"));
				staff.setStaffpassword(rs.getString("staffpassword"));

				staffs.add(staff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, rs);
		}
		return staffs;
	}

}
