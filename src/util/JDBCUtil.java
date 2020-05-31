package util;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

/*
 * ���ݿ⹤����
 */
public class JDBCUtil {
	private static String driver = "com.mysql.jdbc.Driver";// ���ݿ���������
	private static String url = "jdbc:mysql://localhost:3306/supma?characterEncoding=utf-8";// ���ݿ����Ӳ���
	private static String username = "root";// ���ݿ������û���
	private static String password = "123456";// ���ݿ���������

	public static Connection conn = null;

	/*
	 * ��ȡ���ݿ�����
	 */
	public static Connection getConn() {

		try {
			// �������ݿ�����
			Class.forName(driver);
			// ���������ȡ����
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * ��ȡԤ����PrepardStatment����
	 */
	public static PreparedStatement getPs(String sql) {
		PreparedStatement ps = null;
		try {
			// ����Ԥ������� ��Ҫ�������Ӷ���
			ps = getConn().prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	/*
	 * �ر���Դ
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
