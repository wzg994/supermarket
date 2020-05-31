package services;

import java.util.List;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;

/*
 * ����Աҵ���߼�ʵ����
 */
public class UserServiceImpl implements UserService {
	// �����û������ӿ�
	private UserDao userDao;
	// ����� ���󴴽�ʱִ��
	{
		userDao = new UserDaoImpl();
	}

	// ����Ա��¼
	@Override
	public User login(String username, String password) {
		User selectUser = userDao.selectUser(username, password);
		return selectUser;
	}

	// ����Աע��
	@Override
	public int register(User user) {
		int out = 0;
		// �������ݿ�֮ǰ���в�ѯ�û���
		String name = userDao.selectUserName(user.getUsername());
		// �ж�
		if (name != null) {// ���ݿ���ڸ��û���
			out = 0;
		} else {// ���ݿⲻ���ڸ��û���
			out = userDao.insertUser(user);
		}
		return out;
	}

	// ��ʾ����Ա��Ϣ
	@Override
	public List<User> showUser() {
		List<User> users = userDao.showUser();
		return users;
	}

	// ��ʾ��ҳ
	@Override
	public List<User> getAdminByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		List<User> userByPage = userDao.getUserByPage(begin, end);
		return userByPage;
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = userDao.showUser().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// ���ݹ���Ա���ֻ�ȡ�û���Ϣ
	@Override
	public User getAdminByName(String name) {
		User selectUserName = userDao.getAdminByName(name);
		return selectUserName;
	}

	// �޸Ĺ���Ա����
	@Override
	public int updateAdminPassword(User user) {
		int out = userDao.updateAdmin(user);
		return out;
	}

	// ��֤����Ա�˺��Ƿ����
	@Override
	public boolean existName(String username) {
		User user = userDao.getAdminByName(username);
		if (user != null)
			return true;
		return false;
	}

	// ���ݹ���Աid��ȡ����Ա��Ϣ
	@Override
	public User getAdminById(int adminid) {
		User adminById = userDao.getAdminById(adminid);
		return adminById;
	}

	// ɾ������Ա
	@Override
	public int deleAdmin(User user) {
		int out = userDao.deleAdmin(user);
		return out;
	}

	// ���ݹ���Աid��ȡ����Ա��Ϣ�б�
	@Override
	public List<User> getAdminByNames(String adminname) {
		List<User> selectAdmin = userDao.selectAdmin(adminname);
		return selectAdmin;
	}

	// �޸Ĺ���Ա��Ϣ
	@Override
	public int updateAdmin(User user) {
		int out = userDao.updateAdmin(user);
		return out;
	}

}
