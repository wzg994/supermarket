package services;

import java.util.List;

import beans.Purchase;

/*
 * ����ҵ���߼���ӿ�
 */
public interface PurchaseService {
	// ��ʾ������Ϣ
	public List<Purchase> showPurchase();

	// ����id��ʾ������Ϣ
	public Purchase getPurchaseId(int id);

	// ��ҳ��ѯ
	public List<Purchase> getPurchaseByPage(String nowpage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllPage(String pageSize);

	// ɾ��������Ϣ
	public int delePurchase(Purchase purchase);

	// ��ӽ�����Ϣ
	public int addPurchase(Purchase purchase);

	// �޸Ľ�����Ϣ
	public int uqdatePurchase(Purchase purchase);

	// ������Ʒ����ģ����ѯ��Ϣ
	public List<Purchase> selectPurchaseByName(String shopname);
}
