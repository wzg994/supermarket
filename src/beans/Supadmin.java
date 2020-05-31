package beans;

import lombok.Data;

/*
 * 封装数据库超级管理员表
 */
@Data
public class Supadmin {
	private int id;// 用户id
	private String supname; // 用户名
	private String suppassword;// 密码
}
