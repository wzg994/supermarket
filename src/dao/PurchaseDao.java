package dao;

import java.util.List;

import beans.Purchase;

/*
 * ������Ϣ�����ӿ�
 */
public interface PurchaseDao {
	// ��ѯ�����б�
	public List<Purchase> getPurchases();

	// ��ҳ��ѯ�����б�
	public List<Purchase> getPurchaseByPage(int bengin, int end);

	// ���ݶ�����Ų�ѯ�����б�
	public List<Purchase> selectPurchase(Purchase purchase);

	// ���ݽ�����Ż�ȡ������Ϣ
	public Purchase getPurchaseById(int id);

	// ��������
	public int addPurchase(Purchase purchase);

	// ���¶���
	public int updatePurchase(Purchase purchase);

	// ɾ������
	public int delePurchase(Purchase purchase);

	// ���ݽ�����Ʒ����ģ����ѯ�����б�
	public List<Purchase> selectPurchaseByName(String shopname);

}
