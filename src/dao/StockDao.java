package dao;

import java.util.List;

import beans.Stock;

/*
 * 商品库存操作接口
 */
public interface StockDao {
	// 查询库存信息列表
	public List<Stock> getStocks();

	// 根据商品id查询商品库存
	public Stock getStockById(int id);

	// 根据商品名称查询商品库存
	public Stock getStockByName(String shopname);

	// 分页查询库存信息
	public List<Stock> getStockByPage(int begin, int end);

	// 查询库存信息
	public List<Stock> selectSale(Stock stock);

	// 查询库存信息
	public List<Stock> selectStock(Stock stock);

	// 添加库存信息
	public int addSale(Stock stock);

	// 修改库存信息
	public int updateSale(Stock stock);

	// 删除库存信息
	public int deleSale(Stock stock);
}
