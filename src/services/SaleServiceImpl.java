package services;

import java.util.List;

import beans.Sale;
import dao.SaleDao;
import dao.SaleDaoImpl;

/*
 * 销售业务逻辑实现接口
 */
public class SaleServiceImpl implements SaleService {
	// 加载销售操作接口
	private SaleDao saleDao;
	{
		saleDao = new SaleDaoImpl();
	}

	// 显示销售信息列表
	@Override
	public List<Sale> showSales() {
		return saleDao.getSales();
	}

	// 根据id显示销售信息
	@Override
	public Sale getSaleId(int id) {
		Sale sale = null;
		sale = saleDao.getSaleById(id);
		return sale;
	}

	// 删除销售信息
	@Override
	public int deleSale(Sale sale) {
		int out = 0;
		out = saleDao.deleSale(sale);
		return out;
	}

	// 添加销售信息
	@Override
	public int addSale(Sale sale) {
		int out = 0;
		out = saleDao.addSale(sale);
		return out;
	}

	// 修改销售信息
	@Override
	public int updateSale(Sale sale) {
		int out = 0;
		out = saleDao.updateSale(sale);
		return out;
	}

	// 分页查询
	@Override
	public List<Sale> getSaleByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return saleDao.getSaleByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = saleDao.getSales().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
