package services;

import java.util.List;

import beans.Stock;

/*
 * 商品库存业务逻辑层接口
 */
public interface StockService {
	// 显示商品库存列表
	public List<Stock> showStocks();

	// 根据id显示库存信息
	public Stock getSaleById(int id);

	// 根据商品名称查询信息
	public Stock getSaleByName(String shopname);

	// 分页查询
	public List<Stock> getStockByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 删除库存信息
	public int deleStock(Stock stock);

	// 添加库存信息
	public int addstock(Stock stock);

	// 修改库存信息
	public int updateStock(Stock stock);

	// 获取库存数量不足的商品
	public List<Stock> getStockNum(List<Stock> stocks);
}
