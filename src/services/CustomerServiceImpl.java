package services;

import java.util.List;

import beans.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

/*
 * 客户业务逻辑层实现类
 */
public class CustomerServiceImpl implements CustomerService {
	// 加载客户操作接口
	private CustomerDao customerDao;
	{
		customerDao = new CustomerDaoImpl();
	}

	// 显示客户
	@Override
	public List<Customer> showCustomer() {
		return customerDao.getCustomer();
	}

	// 删除客户
	@Override
	public int deleCustomer(Customer customer) {
		int out = 0;
		out = customerDao.deleCustomer(customer);
		return out;
	}

	// 添加客户
	@Override
	public int addcustomer(Customer customer) {
		int out = 0;
		out = customerDao.addCustomer(customer);
		return out;
	}

	// 分页查询客户信息
	@Override
	public List<Customer> getCoustomerByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return customerDao.getCustomerByPage(begin, end);
	}

	// 获取客户信息总页数
	@Override
	public int getAllpage(String pageSize) {
		int total = customerDao.getCustomer().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}
}
