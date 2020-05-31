package services;

import beans.Supadmin;
import dao.SupadminDao;
import dao.SupadminDaoImpl;

/*
 * ��������Աҵ���߼�ʵ����
 */
public class SupadminServiceImpl implements SupadminService {
	// ���س�������Ա�����ӿ�
	private SupadminDao supadminDao;
	{
		supadminDao = new SupadminDaoImpl();
	}

	// ��������Ա�û�����
	@Override
	public Supadmin login(String supname, String password) {
		Supadmin supadmin = supadminDao.selectSupadmin(supname, password);
		return supadmin;
	}

	// ��֤��������Ա�û��Ƿ����
	@Override
	public boolean exitName(String supname) {
		// �������ƻ�ȡ��������Ա��Ϣ
		Supadmin supadmin = supadminDao.getSupadminByName(supname);
		// �����������Ա��Ϣ���ڷ���true���������򷵻�false
		if (supadmin != null)
			return true;
		return false;
	}

}
