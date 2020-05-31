package services;

import java.util.List;

import beans.Purchase;

/*
 * 进货业务逻辑层接口
 */
public interface PurchaseService {
	// 显示进货信息
	public List<Purchase> showPurchase();

	// 根据id显示进货信息
	public Purchase getPurchaseId(int id);

	// 分页查询
	public List<Purchase> getPurchaseByPage(String nowpage, String pageSize);

	// 获取总页数
	public int getAllPage(String pageSize);

	// 删除进货信息
	public int delePurchase(Purchase purchase);

	// 添加进货信息
	public int addPurchase(Purchase purchase);

	// 修改进货信息
	public int uqdatePurchase(Purchase purchase);

	// 根据商品名称模糊查询信息
	public List<Purchase> selectPurchaseByName(String shopname);
}
