package dao;

import java.util.List;

import beans.User;

/*
 * ����Ա�����ӿ�
 */
public interface UserDao {

	// ��ѯ����Ա
	public User selectUser(String username, String password);

	// ���ݹ���Ա���Ʋ�ѯ����Ա
	public String selectUserName(String userName);

	// ��ѯ����Ա��Ϣ�б�
	public List<User> showUser();

	// ��ҳ��ѯ����Ա��Ϣ
	public List<User> getUserByPage(int begin, int end);

	// ɾ������Ա
	public int deleAdmin(User user);

	// �޸Ĺ���Ա
	public int updateAdmin(User user);

	// ��������Ա
	public int insertUser(User user);

	// ���ݹ���Ա���Ʋ�ѯ����Ա
	public User getAdminByName(String name);

	// ���ݹ���Աid��ѯ����Ա
	public User getAdminById(int adminid);

	// ��ѯ���������Ĺ���Ա��Ϣ
	public List<User> selectAdmin(String adminname);
}