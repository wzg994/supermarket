package services;

import beans.Supadmin;

/*
 * ��������Աҵ���߼���ӿ�
 */
public interface SupadminService {

	// ��������Ա�û�����
	public Supadmin login(String supname, String password);

	// ��֤��������Ա�û��Ƿ����
	public boolean exitName(String supname);
}
