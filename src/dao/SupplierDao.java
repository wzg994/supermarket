package dao;

import java.util.List;

import beans.Supplier;

/*
 * 供应商操作接口
 */
public interface SupplierDao {

	// 查询供应商列表
	public List<Supplier> getSupplier();

	// 根据供应商id获取供应商信息
	public Supplier getSupById(int id);

	// 查询供应商
	public Supplier selectSupplier(Supplier supplier);

	// 分页查询供应商信息
	public List<Supplier> getSupplierByPage(int begin, int end);

	// 添加供应商
	public int addSupplier(Supplier supplier);

	// 修改供应商信息
	public int updateSupplier(Supplier supplier);

	// 删除供应商
	public int deleSupplier(Supplier supplier);

	// 根据供应商名称查询信息
	public List<Supplier> getSupplier(String suppilername);
}
