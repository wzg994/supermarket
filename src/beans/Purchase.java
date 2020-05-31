package beans;

import java.util.Date;

import lombok.Data;

/*
 * 封装数据库进货表
 */
@Data
public class Purchase {
	private int purid;// 订单id
	private String shopid;// 商品id
	private String shopname;// 商品名称
	private Double shopprice;// 商品价格
	private int shopnum;// 商品数量
	private Date purdate;// 进货日期
	private String supname;// 供应商名字
}
