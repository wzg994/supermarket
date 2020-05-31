package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Supadmin;
import util.JDBCUtil;

/*
 * 超级管理员接口实现类
 */
public class SupadminDaoImpl implements SupadminDao {

	// 查询超级管理员
	@Override
	public Supadmin selectSupadmin(String supname, String password) {
		Supadmin supadmin = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			String sql = "select * from supadmin where supname=? and suppassword=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, supname);
			ps.setObject(2, password);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				supadmin = new Supadmin();
				supadmin.setId(rs.getInt("id"));
				supadmin.setSupname(rs.getString("supname"));
				supadmin.setSuppassword(rs.getString("suppassword"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return supadmin;
	}

	// 根据超级管理员名称查询超级管理员
	@Override
	public Supadmin getSupadminByName(String supname) {
		Supadmin supadmin = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			String sql = "select * from supadmin where supname=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, supname);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				supadmin = new Supadmin();
				supadmin.setId(rs.getInt("id"));
				supadmin.setSupname(rs.getString("supname"));
				supadmin.setSuppassword(rs.getString("suppassword"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return supadmin;
	}

}
