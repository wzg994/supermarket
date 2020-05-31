package beans;

import java.util.Date;

import lombok.Data;

/*
 * 封装数据库商品表
 */
@Data
public class Product {
	private String proid;// 商品id
	private String pname;// 商品名称
	private Double price;// 商品价格
	private int pronum;// 商品数量
	private Date prodate;// 商品进货日期
	private String supname;// 供应商名称
	private String typename;// 类型名称
	private Date reledate;// 过期时间
	private String unit;// 计件方式

}
