package services;

import java.util.ArrayList;
import java.util.List;

import beans.Stock;
import dao.StockDao;
import dao.StockDaoImpl;

/*
 * ��Ʒ���ҵ���߼�ʵ����
 */
public class StockServiceImpl implements StockService {
	// ������Ʒ�������ӿ�
	private StockDao stockDao;
	{
		stockDao = new StockDaoImpl();
	}

	// ��ʾ��Ʒ����б�
	@Override
	public List<Stock> showStocks() {
		return stockDao.getStocks();
	}

	// ����id��ʾ�����Ϣ
	@Override
	public Stock getSaleById(int id) {
		Stock stock = stockDao.getStockById(id);
		return stock;
	}

	// ɾ�������Ϣ
	@Override
	public int deleStock(Stock stock) {
		int out = stockDao.deleSale(stock);
		return out;
	}

	// ��ӿ����Ϣ
	@Override
	public int addstock(Stock stock) {
		int out = stockDao.addSale(stock);
		return out;
	}

	// �޸Ŀ����Ϣ
	@Override
	public int updateStock(Stock stock) {
		int out = stockDao.updateSale(stock);
		return out;
	}

	// ��ҳ��ѯ
	@Override
	public List<Stock> getStockByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return stockDao.getStockByPage(begin, end);
	}

	// ��ҳ��ѯ
	@Override
	public int getAllpage(String pageSize) {
		int total = stockDao.getStocks().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// ������Ʒ���Ʋ�ѯ��Ϣ
	@Override
	public Stock getSaleByName(String shopname) {
		Stock stock = stockDao.getStockByName(shopname);
		return stock;
	}

	// ��ȡ��������������Ʒ
	@Override
	public List<Stock> getStockNum(List<Stock> stocks) {
		List<Stock> stock = new ArrayList<Stock>();
		for (Stock stock2 : stocks) {
			// ������Ʒid��ȡ��Ʒ�����Ϣ
			Stock stockById = stockDao.getStockById(stock2.getShopid());
			// �ж���Ʒ�����Ƿ�С��100������Ǽ��뵽�����������ļ�����
			if (stockById.getShopnum() < 100) {
				stock.add(stockById);
			}
		}
		return stock;
	}

}
