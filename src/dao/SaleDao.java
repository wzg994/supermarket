package dao;

import java.util.List;

import beans.Sale;

/*
 * ���۲����ӿ�
 */
public interface SaleDao {
	// ��ѯ������Ϣ�б�
	public List<Sale> getSales();

	// ��������id��ȡ������Ϣ
	public Sale getSaleById(int id);

	// ��ҳ��ʾ������Ϣ
	public List<Sale> getSaleByPage(int begin, int end);

	// ��ѯ������Ϣ
	public Sale selectSale(Sale sale);

	// ��ѯ������Ϣ
	public List<Sale> selectSales(Sale sale);

	// ���������Ϣ
	public int addSale(Sale sale);

	// �޸���������Ϣ
	public int updateSale(Sale sale);

	// ɾ��������Ϣ
	public int deleSale(Sale sale);
}
