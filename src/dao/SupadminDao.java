package dao;

import beans.Supadmin;;

/*
 * 超级管理员操作接口
 */
public interface SupadminDao {

	// 查询超级管理员用户
	public Supadmin selectSupadmin(String supname, String password);

	// 根据超级管理员名查询超级管理员
	public Supadmin getSupadminByName(String supname);
}
