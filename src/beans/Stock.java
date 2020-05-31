package beans;

import lombok.Data;

/*
 * 封装数据库商品库存表
 */
@Data
public class Stock {
	private int shopid;// 商品id
	private String shopname;// 商品名称
	private int shopnum;// 商品数量
	private String mark;// 商品备注
}
