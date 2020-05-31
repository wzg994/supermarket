package dao;

import java.util.List;

import beans.Purchase;

/*
 * 进货信息操作接口
 */
public interface PurchaseDao {
	// 查询进货列表
	public List<Purchase> getPurchases();

	// 分页查询进货列表
	public List<Purchase> getPurchaseByPage(int bengin, int end);

	// 根据订单编号查询货物列表
	public List<Purchase> selectPurchase(Purchase purchase);

	// 根据进货编号获取进货信息
	public Purchase getPurchaseById(int id);

	// 新增订单
	public int addPurchase(Purchase purchase);

	// 更新订单
	public int updatePurchase(Purchase purchase);

	// 删除订单
	public int delePurchase(Purchase purchase);

	// 根据进货商品名称模糊查询货物列表
	public List<Purchase> selectPurchaseByName(String shopname);

}
