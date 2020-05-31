package services;

import beans.Supadmin;

/*
 * 超级管理员业务逻辑层接口
 */
public interface SupadminService {

	// 超级管理员用户登入
	public Supadmin login(String supname, String password);

	// 验证超级管理员用户是否存在
	public boolean exitName(String supname);
}
