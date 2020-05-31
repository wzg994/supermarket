package services;

import java.util.List;

import beans.Stock;

/*
 * ��Ʒ���ҵ���߼���ӿ�
 */
public interface StockService {
	// ��ʾ��Ʒ����б�
	public List<Stock> showStocks();

	// ����id��ʾ�����Ϣ
	public Stock getSaleById(int id);

	// ������Ʒ���Ʋ�ѯ��Ϣ
	public Stock getSaleByName(String shopname);

	// ��ҳ��ѯ
	public List<Stock> getStockByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// ɾ�������Ϣ
	public int deleStock(Stock stock);

	// ��ӿ����Ϣ
	public int addstock(Stock stock);

	// �޸Ŀ����Ϣ
	public int updateStock(Stock stock);

	// ��ȡ��������������Ʒ
	public List<Stock> getStockNum(List<Stock> stocks);
}
