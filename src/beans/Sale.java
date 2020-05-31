package beans;

import java.util.Date;

import lombok.Data;

/*
 * 封装数据库销售表
 */
@Data
public class Sale {
	private int saleid;// 销售id
	private int shopid;// 商品id
	private String shopname;// 商品名称
	private double shopprice;// 商品价格
	private int shopnum;// 商品数量
	private double totalprice;// 商品总价
	private Date saledate;// 销售日期
	private String cusname;// 客户名称
	private String cusid;// 客户id
	private String mark;// 备注
}
