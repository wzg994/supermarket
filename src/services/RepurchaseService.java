package services;

import java.util.List;

import beans.Repurchase;

/*
 * 退货业务逻辑层接口
 */
public interface RepurchaseService {
	// 显示退货信息列表
	public List<Repurchase> showRepurchase();

	// 根据订单id显示退货信息
	public Repurchase getRepurchaseById(int id);

	// 分页查询
	public List<Repurchase> getRepurchaseByPage(String nowpage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 删除退货信息
	public int deleRepurcahse(Repurchase repurchase);

	// 添加退货信息
	public int addRepurchase(Repurchase repurchase);

	// 修改退货信息
	public int updateRechase(Repurchase repurchase);

	// 根据退货商品模糊查询退货信息列表
	public List<Repurchase> selectPepurchaseByName(String shopname);
}
