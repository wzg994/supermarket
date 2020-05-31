package services;

import java.util.List;

import beans.Purchase;
import dao.PurchaseDao;
import dao.PurchaseDaoImpl;

/*
 * ����ҵ���߼���ʵ����
 */
public class PurchaseServiceImpl implements PurchaseService {
	// ���ؽ��������ӿ�
	PurchaseDao purchaseDao;
	{
		purchaseDao = new PurchaseDaoImpl();
	}

	// ��ʾ������Ϣ
	@Override
	public List<Purchase> showPurchase() {
		return purchaseDao.getPurchases();
	}

	// ����id��ʾ������Ϣ
	@Override
	public Purchase getPurchaseId(int id) {
		Purchase purchase = purchaseDao.getPurchaseById(id);
		return purchase;
	}

	// ��ҳ��ѯ
	@Override
	public int delePurchase(Purchase purchase) {
		int out = purchaseDao.delePurchase(purchase);
		return out;
	}

	// ��ӽ�����Ϣ
	@Override
	public int addPurchase(Purchase purchase) {
		int out = purchaseDao.addPurchase(purchase);
		return out;
	}

	// �޸Ľ�����Ϣ
	@Override
	public int uqdatePurchase(Purchase purchase) {
		int out = purchaseDao.updatePurchase(purchase);
		return out;
	}

	// ��ҳ��ѯ������Ϣ
	@Override
	public List<Purchase> getPurchaseByPage(String nowpage, String pageSize) {
		int begin = (Integer.parseInt(nowpage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return purchaseDao.getPurchaseByPage(begin, end);
	}

	// ��ȡ��ҳ��
	@Override
	public int getAllPage(String pageSize) {
		int total = purchaseDao.getPurchases().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// ������Ʒ����ģ����ѯ��Ϣ
	@Override
	public List<Purchase> selectPurchaseByName(String shopname) {
		List<Purchase> selectPurchaseByName = purchaseDao.selectPurchaseByName(shopname);
		return selectPurchaseByName;
	}

}
