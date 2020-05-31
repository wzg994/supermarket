package beans;

import lombok.Data;

/*
 * 封装数据库供应商表
 */
@Data
public class Supplier {
	private int supid;// 供应商id
	private String supname;// 供应商名字
	private String suptel;// 供应商电话
	private String person;// 负责人
	private String address;// 供应商地址
	private String email;// 供应商邮箱
}
