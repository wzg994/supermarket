package services;

import java.util.List;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

/*
 * 管理员业务逻辑实现类
 */
public class UserServiceImpl implements UserService {
	// 加载用户操作接口
	private UserDao userDao;
	// 对象块 对象创建时执行
	{
		userDao = new UserDaoImpl();
	}

	// 管理员登录
	@Override
	public User login(String username, String password) {
		User selectUser = userDao.selectUser(username, password);
		return selectUser;
	}

	// 管理员注册
	@Override
	public int register(User user) {
		int out = 0;
		// 插入数据库之前进行查询用户名
		String name = userDao.selectUserName(user.getUsername());
		// 判断
		if (name != null) {// 数据库存在该用户名
			out = 0;
		} else {// 数据库不存在该用户名
			out = userDao.insertUser(user);
		}
		return out;
	}

	// 显示管理员信息
	@Override
	public List<User> showUser() {
		List<User> users = userDao.showUser();
		return users;
	}

	// 显示分页
	@Override
	public List<User> getAdminByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		List<User> userByPage = userDao.getUserByPage(begin, end);
		return userByPage;
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = userDao.showUser().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 根据管理员名字获取用户信息
	@Override
	public User getAdminByName(String name) {
		User selectUserName = userDao.getAdminByName(name);
		return selectUserName;
	}

	// 修改管理员密码
	@Override
	public int updateAdminPassword(User user) {
		int out = userDao.updateAdmin(user);
		return out;
	}

	// 验证管理员账号是否存在
	@Override
	public boolean existName(String username) {
		User user = userDao.getAdminByName(username);
		if (user != null)
			return true;
		return false;
	}

	// 根据管理员id获取管理员信息
	@Override
	public User getAdminById(int adminid) {
		User adminById = userDao.getAdminById(adminid);
		return adminById;
	}

	// 删除管理员
	@Override
	public int deleAdmin(User user) {
		int out = userDao.deleAdmin(user);
		return out;
	}

	// 根据管理员id获取管理员信息列表
	@Override
	public List<User> getAdminByNames(String adminname) {
		List<User> selectAdmin = userDao.selectAdmin(adminname);
		return selectAdmin;
	}

	// 修改管理员信息
	@Override
	public int updateAdmin(User user) {
		int out = userDao.updateAdmin(user);
		return out;
	}

}
