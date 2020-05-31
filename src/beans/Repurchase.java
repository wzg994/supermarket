package beans;

import java.util.Date;

import lombok.Data;

/*
 * 封装数据库退货表
 */
@Data
public class Repurchase {
	private int repurid;// 订单编号
	private int purid;// 订单编号
	private int shopid;// 商品id
	private String shopname;// 商品名称
	private double shopprice;// 商品数量
	private int shopnum;// 商品数量
	private Date purdate;// 进货日期
	private Date redate;// 退货日期
	private String reson;// 退货原因
	private String mark;// 退货备注
}
