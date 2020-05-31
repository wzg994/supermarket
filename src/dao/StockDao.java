package dao;

import java.util.List;

import beans.Stock;

/*
 * ��Ʒ�������ӿ�
 */
public interface StockDao {
	// ��ѯ�����Ϣ�б�
	public List<Stock> getStocks();

	// ������Ʒid��ѯ��Ʒ���
	public Stock getStockById(int id);

	// ������Ʒ���Ʋ�ѯ��Ʒ���
	public Stock getStockByName(String shopname);

	// ��ҳ��ѯ�����Ϣ
	public List<Stock> getStockByPage(int begin, int end);

	// ��ѯ�����Ϣ
	public List<Stock> selectSale(Stock stock);

	// ��ѯ�����Ϣ
	public List<Stock> selectStock(Stock stock);

	// ��ӿ����Ϣ
	public int addSale(Stock stock);

	// �޸Ŀ����Ϣ
	public int updateSale(Stock stock);

	// ɾ�������Ϣ
	public int deleSale(Stock stock);
}
