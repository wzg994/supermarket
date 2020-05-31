package services;

import java.util.List;

import beans.User;

/*
 * ����Աҵ���߼���
 */
public interface UserService {

	// ����Ա��¼
	public User login(String username, String password);

	// ����Աע��
	public int register(User user);

	// ��ʾ����Ա��Ϣ
	public List<User> showUser();

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ��ʾ��ҳ
	public List<User> getAdminByPage(String nowPage, String pageSize);

	// ���ݹ���Ա���ֻ�ȡ�û���Ϣ
	public User getAdminByName(String name);

	// �޸Ĺ���Ա����
	public int updateAdminPassword(User user);

	// ��֤����Ա�˺��Ƿ����
	public boolean existName(String username);

	// ���ݹ���Աid��ȡ����Ա��Ϣ
	public User getAdminById(int adminid);

	// ɾ������Ա
	public int deleAdmin(User user);

	// ���ݹ���Աid��ȡ����Ա��Ϣ�б�
	public List<User> getAdminByNames(String adminname);

	// �޸Ĺ���Ա��Ϣ
	public int updateAdmin(User user);

}
