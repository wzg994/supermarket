package dao;

import java.util.List;

import beans.Customer;

/*
 * 客户操作接口
 */
public interface CustomerDao {
	// 查询客户列表
	public List<Customer> getCustomer();

	// 根据客户id查询客户信息
	public Customer getCustomerById(int id);

	// 分页添加客户信息
	public List<Customer> getCustomerByPage(int begin, int end);

	// 添加客户
	public int addCustomer(Customer customer);

	// 修改客户
	public int updateCustomr(Customer customer);

	// 删除客户
	public int deleCustomer(Customer customer);

	// 查询客户信息
	public List<Customer> selectCustomer(Customer customer);

}
