package services;

import java.util.List;

import beans.Supplier;
import dao.SupplierDao;
import dao.SupplierDaoImpl;

/*
 * 供应商业务逻辑实现类
 */
public class SupplierServiceImpl implements SupplierService {
	// 加载供应商操作接口
	private SupplierDao supplierDao;
	{
		supplierDao = new SupplierDaoImpl();
	}

	// 显示供应商
	@Override
	public List<Supplier> showSupplier() {
		return supplierDao.getSupplier();
	}

	// 删除供应商
	@Override
	public int deleSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.deleSupplier(supplier);
		return out;
	}

	// 添加供应商
	@Override
	public int addSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.addSupplier(supplier);
		return out;
	}

	// 修改供应商信息
	@Override
	public int updateSupplier(Supplier supplier) {
		int out = 0;
		out = supplierDao.updateSupplier(supplier);
		return out;
	}

	// 根据供应商id获取供应商信息
	@Override
	public Supplier getSupplierId(int id) {
		Supplier supplier;
		supplier = supplierDao.getSupById(id);
		return supplier;
	}

	// 分页查询
	@Override
	public List<Supplier> getSupplierByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return supplierDao.getSupplierByPage(begin, end);
	}

	// 获取总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = supplierDao.getSupplier().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}

}
