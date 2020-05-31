package services;

import beans.Supadmin;
import dao.SupadminDao;
import dao.SupadminDaoImpl;

/*
 * 超级管理员业务逻辑实现类
 */
public class SupadminServiceImpl implements SupadminService {
	// 加载超级管理员操作接口
	private SupadminDao supadminDao;
	{
		supadminDao = new SupadminDaoImpl();
	}

	// 超级管理员用户登入
	@Override
	public Supadmin login(String supname, String password) {
		Supadmin supadmin = supadminDao.selectSupadmin(supname, password);
		return supadmin;
	}

	// 验证超级管理员用户是否存在
	@Override
	public boolean exitName(String supname) {
		// 根据名称获取超级管理员信息
		Supadmin supadmin = supadminDao.getSupadminByName(supname);
		// 如果超级管理员信息存在返回true，不存在则返回false
		if (supadmin != null)
			return true;
		return false;
	}

}
