package services;

import java.util.List;

import beans.Purchase;
import dao.PurchaseDao;
import dao.PurchaseDaoImpl;

/*
 * 进货业务逻辑层实现类
 */
public class PurchaseServiceImpl implements PurchaseService {
	// 加载进货操作接口
	PurchaseDao purchaseDao;
	{
		purchaseDao = new PurchaseDaoImpl();
	}

	// 显示进货信息
	@Override
	public List<Purchase> showPurchase() {
		return purchaseDao.getPurchases();
	}

	// 根据id显示进货信息
	@Override
	public Purchase getPurchaseId(int id) {
		Purchase purchase = purchaseDao.getPurchaseById(id);
		return purchase;
	}

	// 分页查询
	@Override
	public int delePurchase(Purchase purchase) {
		int out = purchaseDao.delePurchase(purchase);
		return out;
	}

	// 添加进货信息
	@Override
	public int addPurchase(Purchase purchase) {
		int out = purchaseDao.addPurchase(purchase);
		return out;
	}

	// 修改进货信息
	@Override
	public int uqdatePurchase(Purchase purchase) {
		int out = purchaseDao.updatePurchase(purchase);
		return out;
	}

	// 分页查询进货信息
	@Override
	public List<Purchase> getPurchaseByPage(String nowpage, String pageSize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return purchaseDao.getPurchaseByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllPage(String pageSize) {
		int total = purchaseDao.getPurchases().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 根据商品名称模糊查询信息
	@Override
	public List<Purchase> selectPurchaseByName(String shopname) {
		List<Purchase> selectPurchaseByName = purchaseDao.selectPurchaseByName(shopname);
		return selectPurchaseByName;
	}

}
