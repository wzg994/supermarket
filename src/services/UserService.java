package services;

import java.util.List;

import beans.User;

/*
 * 管理员业务逻辑层
 */
public interface UserService {

	// 管理员登录
	public User login(String username, String password);

	// 管理员注册
	public int register(User user);

	// 显示管理员信息
	public List<User> showUser();

	// 获取总页数
	public int getAllpage(String pageSize);

	// 显示分页
	public List<User> getAdminByPage(String nowPage, String pageSize);

	// 根据管理员名字获取用户信息
	public User getAdminByName(String name);

	// 修改管理员密码
	public int updateAdminPassword(User user);

	// 验证管理员账号是否存在
	public boolean existName(String username);

	// 根据管理员id获取管理员信息
	public User getAdminById(int adminid);

	// 删除管理员
	public int deleAdmin(User user);

	// 根据管理员id获取管理员信息列表
	public List<User> getAdminByNames(String adminname);

	// 修改管理员信息
	public int updateAdmin(User user);

}
