package beans;

import lombok.Data;

/*
 * 封装数据库用户表
 */
@Data
public class User {
	private int id;// 用户id
	private String username; // 用户名
	private String password;// 密码
}
