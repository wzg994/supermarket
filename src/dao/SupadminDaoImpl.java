package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Supadmin;
import util.JDBCUtil;

/*
 * ��������Ա�ӿ�ʵ����
 */
public class SupadminDaoImpl implements SupadminDao {

	// ��ѯ��������Ա
	@Override
	public Supadmin selectSupadmin(String supname, String password) {
		Supadmin supadmin = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			String sql = "select * from supadmin where supname=? and suppassword=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, supname);
			ps.setObject(2, password);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				supadmin = new Supadmin();
				supadmin.setId(rs.getInt("id"));
				supadmin.setSupname(rs.getString("supname"));
				supadmin.setSuppassword(rs.getString("suppassword"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return supadmin;
	}

	// ���ݳ�������Ա���Ʋ�ѯ��������Ա
	@Override
	public Supadmin getSupadminByName(String supname) {
		Supadmin supadmin = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			String sql = "select * from supadmin where supname=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, supname);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				supadmin = new Supadmin();
				supadmin.setId(rs.getInt("id"));
				supadmin.setSupname(rs.getString("supname"));
				supadmin.setSuppassword(rs.getString("suppassword"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return supadmin;
	}

}
