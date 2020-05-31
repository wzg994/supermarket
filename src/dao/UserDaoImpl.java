package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import beans.User;
import util.JDBCUtil;

/*
 * 管理员操作接口的实现类
 */
public class UserDaoImpl implements UserDao {

	// 根据管理员名称和id查询管理员
	@Override
	public User selectUser(String username, String password) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			String sql = "select * from user where username=? and password=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, username);
			ps.setObject(2, password);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// 新增管理员
	@Override
	public int insertUser(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "insert into user(username,password) values(?,?) ";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, user.getUsername());
			ps.setObject(2, user.getPassword());
			// 执行
			// 返回受影响行数
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 根据管理员姓名查询管理员
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
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return name;
	}

	// 查询管理员信息列表
	@Override
	public List<User> showUser() {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			users = new ArrayList<User>();
			String sql = "select * from user ";
			ps = JDBCUtil.getPs(sql);
			// 设置参数

			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

	// 分页查询管理员信息
	@Override
	public List<User> getUserByPage(int begin, int end) {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			users = new ArrayList<User>();
			String sql = "select * from user LIMIT ?,?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, begin);
			ps.setObject(2, end);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

	// 删除管理员
	@Override
	public int deleAdmin(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM user where id=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, user.getId());
			// 执行
			// 返回受影响行数
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 修改管理员
	@Override
	public int updateAdmin(User user) {
		int out = 0;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE user SET username=?,password=? WHERE id=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, user.getUsername());
			ps.setObject(2, user.getPassword());
			ps.setObject(3, user.getId());
			// 执行
			// 返回受影响行数
			out = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, null);
		}
		return out;
	}

	// 根据管理员姓名查询管理员
	@Override
	public User getAdminByName(String name) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			String sql = "select * from user where username=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, name);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// 根据管理员id查询管理员信息
	@Override
	public User getAdminById(int adminid) {
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			String sql = "select * from user where id=?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, adminid);
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return user;
	}

	// 根据管理员姓名模糊查询管理员信息列表
	@Override
	public List<User> selectAdmin(String adminname) {
		List<User> users = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 有查询结果都要用到 结果集对象
		try {
			users = new ArrayList<User>();
			String sql = "select * from user WHERE username LIKE ?";
			ps = JDBCUtil.getPs(sql);
			// 设置参数
			ps.setObject(1, "%" + adminname + "%");
			// 执行查询
			rs = ps.executeQuery();
			while (rs.next()) {
				// 从结果集中获取值 然后设置对象属性值
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 关闭资源
			JDBCUtil.close(ps, rs);
		}
		return users;
	}

}