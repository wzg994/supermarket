package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import beans.User;
import util.JDBCUtil;

/*
 * ����Ա�����ӿڵ�ʵ����
 */
public class UserDaoImpl implements UserDao {

	// ���ݹ���Ա���ƺ�id��ѯ����Ա
	@Override
	public User selectUser(String username, String password) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			String sql = "select * from user where username=? and password=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, username);
			ps.setObject(2, password);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// ��������Ա
	@Override
	public int insertUser(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "insert into user(username,password) values(?,?) ";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, user.getUsername());
			ps.setObject(2, user.getPassword());
			// ִ��
			// ������Ӱ������
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ���ݹ���Ա������ѯ����Ա
	@Override
	public String selectUserName(String userName) {
		String name = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select username from user where username=?";
			ps = JDBCUtil.getPs(sql);
			ps.setObject(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return name;
	}

	// ��ѯ����Ա��Ϣ�б�
	@Override
	public List<User> showUser() {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			users = new ArrayList<User>();
			String sql = "select * from user ";
			ps = JDBCUtil.getPs(sql);
			// ���ò���

			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

	// ��ҳ��ѯ����Ա��Ϣ
	@Override
	public List<User> getUserByPage(int begin, int end) {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			users = new ArrayList<User>();
			String sql = "select * from user LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, begin);
			ps.setObject(2, end);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

	// ɾ������Ա
	@Override
	public int deleAdmin(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM user where id=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, user.getId());
			// ִ��
			// ������Ӱ������
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// �޸Ĺ���Ա
	@Override
	public int updateAdmin(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE user SET username=?,password=? WHERE id=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, user.getUsername());
			ps.setObject(2, user.getPassword());
			ps.setObject(3, user.getId());
			// ִ��
			// ������Ӱ������
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// ���ݹ���Ա������ѯ����Ա
	@Override
	public User getAdminByName(String name) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			String sql = "select * from user where username=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, name);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// ���ݹ���Աid��ѯ����Ա��Ϣ
	@Override
	public User getAdminById(int adminid) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			String sql = "select * from user where id=?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, adminid);
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// ���ݹ���Ա����ģ����ѯ����Ա��Ϣ�б�
	@Override
	public List<User> selectAdmin(String adminname) {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // �в�ѯ�����Ҫ�õ� ���������
		try {
			users = new ArrayList<User>();
			String sql = "select * from user WHERE username LIKE ?";
			ps = JDBCUtil.getPs(sql);
			// ���ò���
			ps.setObject(1, "%" + adminname + "%");
			// ִ�в�ѯ
			rs = ps.executeQuery();
			while (rs.next()) {
				// �ӽ�����л�ȡֵ Ȼ�����ö�������ֵ
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

}