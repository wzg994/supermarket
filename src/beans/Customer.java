package beans;

import lombok.Data;

/*
 * 封装数据库客户表
 */
@Data
public class Customer {
	private int cusid;// 客户id
	private String cusname;// 客户姓名
	private String custel;// 客户电话
	private String person;// 负责人
	private String address;// 客户地址
	private String email;// 客户邮箱
}
