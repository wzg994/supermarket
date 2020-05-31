package dao;

import java.util.List;

import beans.User;

/*
 * 管理员操作接口
 */
public interface UserDao {

	// 查询管理员
	public User selectUser(String username, String password);

	// 根据管理员名称查询管理员
	public String selectUserName(String userName);

	// 查询管理员信息列表
	public List<User> showUser();

	// 分页查询管理员信息
	public List<User> getUserByPage(int begin, int end);

	// 删除管理员
	public int deleAdmin(User user);

	// 修改管理员
	public int updateAdmin(User user);

	// 新增管理员
	public int insertUser(User user);

	// 根据管理员名称查询管理员
	public User getAdminByName(String name);

	// 根据管理员id查询管理员
	public User getAdminById(int adminid);

	// 查询符合条件的管理员信息
	public List<User> selectAdmin(String adminname);
}