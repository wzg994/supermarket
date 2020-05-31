package services;

import java.util.ArrayList;
import java.util.List;

import beans.Stock;
import dao.StockDao;
import dao.StockDaoImpl;

/*
 * 商品库存业务逻辑实现类
 */
public class StockServiceImpl implements StockService {
	// 加载商品库存操作接口
	private StockDao stockDao;
	{
		stockDao = new StockDaoImpl();
	}

	// 显示商品库存列表
	@Override
	public List<Stock> showStocks() {
		return stockDao.getStocks();
	}

	// 根据id显示库存信息
	@Override
	public Stock getSaleById(int id) {
		Stock stock = stockDao.getStockById(id);
		return stock;
	}

	// 删除库存信息
	@Override
	public int deleStock(Stock stock) {
		int out = stockDao.deleSale(stock);
		return out;
	}

	// 添加库存信息
	@Override
	public int addstock(Stock stock) {
		int out = stockDao.addSale(stock);
		return out;
	}

	// 修改库存信息
	@Override
	public int updateStock(Stock stock) {
		int out = stockDao.updateSale(stock);
		return out;
	}

	// 分页查询
	@Override
	public List<Stock> getStockByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);
		return stockDao.getStockByPage(begin, end);
	}

	// 分页查询
	@Override
	public int getAllpage(String pageSize) {
		int total = stockDao.getStocks().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

	// 根据商品名称查询信息
	@Override
	public Stock getSaleByName(String shopname) {
		Stock stock = stockDao.getStockByName(shopname);
		return stock;
	}

	// 获取库存数量不足的商品
	@Override
	public List<Stock> getStockNum(List<Stock> stocks) {
		List<Stock> stock = new ArrayList<Stock>();
		for (Stock stock2 : stocks) {
			// 根据商品id获取商品库存信息
			Stock stockById = stockDao.getStockById(stock2.getShopid());
			// 判断商品数量是否小于100，如果是加入到库存数量不足的集合中
			if (stockById.getShopnum() < 100) {
				stock.add(stockById);
			}
		}
		return stock;
	}

}
