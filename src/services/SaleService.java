package services;

import java.util.List;

import beans.Sale;

/*
 * ����ҵ���߼���ӿ�
 */
public interface SaleService {
	// ��ʾ������Ϣ�б�
	public List<Sale> showSales();

	// ����id��ʾ������Ϣ
	public Sale getSaleId(int id);

	// ��ҳ��ѯ
	public List<Sale> getSaleByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ɾ��������Ϣ
	public int deleSale(Sale sale);

	// ���������Ϣ
	public int addSale(Sale sale);

	// �޸�������Ϣ
	public int updateSale(Sale sale);

}
