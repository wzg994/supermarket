package services;

import java.util.List;

import beans.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

/*
 * �ͻ�ҵ���߼���ʵ����
 */
public class CustomerServiceImpl implements CustomerService {
	// ���ؿͻ������ӿ�
	private CustomerDao customerDao;
	{
		customerDao = new CustomerDaoImpl();
	}

	// ��ʾ�ͻ�
	@Override
	public List<Customer> showCustomer() {
		return customerDao.getCustomer();
	}

	// ɾ���ͻ�
	@Override
	public int deleCustomer(Customer customer) {
		int out = 0;
		out = customerDao.deleCustomer(customer);
		return out;
	}

	// ��ӿͻ�
	@Override
	public int addcustomer(Customer customer) {
		int out = 0;
		out = customerDao.addCustomer(customer);
		return out;
	}

	// ��ҳ��ѯ�ͻ���Ϣ
	@Override
	public List<Customer> getCoustomerByPage(String nowPage, String pageSize) {
		int begin = (Integer.parseInt(nowPage) - 1) * (Integer.parseInt(pageSize));
		int end = Integer.parseInt(pageSize);

		return customerDao.getCustomerByPage(begin, end);
	}

	// ��ȡ�ͻ���Ϣ��ҳ��
	@Override
	public int getAllpage(String pageSize) {
		int total = customerDao.getCustomer().size();
		int allpage = (int) Math.ceil((double) total / (Integer.parseInt(pageSize)));
		return allpage;
	}
}
