package services;

import java.util.List;

import beans.Supplier;

/*
 * 供应商业务逻辑层接口
 */
public interface SupplierService {
	// 显示供应商
	public List<Supplier> showSupplier();

	// 根据id显示供应商
	public Supplier getSupplierId(int id);

	// 分页查询
	public List<Supplier> getSupplierByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 删除供应商
	public int deleSupplier(Supplier supplier);

	// 添加供应商
	public int addSupplier(Supplier supplier);

	// 修改供应商
	public int updateSupplier(Supplier supplier);
}
