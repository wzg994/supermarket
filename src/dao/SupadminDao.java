package dao;

import beans.Supadmin;;

/*
 * ��������Ա�����ӿ�
 */
public interface SupadminDao {

	// ��ѯ��������Ա�û�
	public Supadmin selectSupadmin(String supname, String password);

	// ���ݳ�������Ա����ѯ��������Ա
	public Supadmin getSupadminByName(String supname);
}
