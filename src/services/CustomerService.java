package services;

import java.util.List;

import beans.Customer;

/*
 * 客户业务逻辑层接口
 */
public interface CustomerService {
	// 客户信息展示
	public List<Customer> showCustomer();

	// 分页查询客户信息
	public List<Customer> getCoustomerByPage(String nowPage, String pageSize);

	// 获取总页数
	public int getAllpage(String pageSize);

	// 客户信息删除
	public int deleCustomer(Customer customer);

	// 添加客户信息
	public int addcustomer(Customer customer);

}
