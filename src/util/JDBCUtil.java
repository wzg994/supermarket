package util;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

/*
 * 数据库工具类
 */
public class JDBCUtil {
	private static String driver = "com.mysql.jdbc.Driver";// 数据库连接驱动
	private static String url = "jdbc:mysql://localhost:3306/supma?characterEncoding=utf-8";// 数据库连接参数
	private static String username = "root";// 数据库连接用户名
	private static String password = "123456";// 数据库连接密码

	public static Connection conn = null;

	/*
	 * 获取数据库连接
	 */
	public static Connection getConn() {

		try {
			// 加载数据库驱动
			Class.forName(driver);
			// 传入参数获取连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 获取预编译PrepardStatment对象
	 */
	public static PreparedStatement getPs(String sql) {
		PreparedStatement ps = null;
		try {
			// 创建预编译对象 需要数据连接对象
			ps = getConn().prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	/*
	 * 关闭资源
	 */
	public static void close(PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
