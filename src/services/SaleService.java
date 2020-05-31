package services;

import java.util.List;

import beans.Sale;

/*
 * 销售业务逻辑层接口
 */
public interface SaleService {
	// 显示销售信息列表
	public List<Sale> showSales();

	// 根据id显示销售信息
	public Sale getSaleId(int id);

	// 分页查询
	public List<Sale> getSaleByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 删除销售信息
	public int deleSale(Sale sale);

	// 添加销售信息
	public int addSale(Sale sale);

	// 修改销售信息
	public int updateSale(Sale sale);

}
