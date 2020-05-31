package beans;

import lombok.Data;

/*
 * 封装数据库员工表
 */
@Data
public class Staff {
	private String staffid;// 员工id
	private String staffname;// 员工名字
	private String idnum;// 员工身份证
	private String sex;// 员工性别
	private String tel;// 员工电话
	private String staffadd;// 员工地址
	private String staffedu;// 员工学历
	private String staffpassword;// 员工登录密码

}
