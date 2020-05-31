package dao;

import java.util.List;

import beans.Sale;

/*
 * 销售操作接口
 */
public interface SaleDao {
	// 查询销售信息列表
	public List<Sale> getSales();

	// 根据销售id获取销售信息
	public Sale getSaleById(int id);

	// 分页显示销售信息
	public List<Sale> getSaleByPage(int begin, int end);

	// 查询销售信息
	public Sale selectSale(Sale sale);

	// 查询销售信息
	public List<Sale> selectSales(Sale sale);

	// 添加销售信息
	public int addSale(Sale sale);

	// 修改销售新消息
	public int updateSale(Sale sale);

	// 删除销售信息
	public int deleSale(Sale sale);
}
