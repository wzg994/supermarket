package services;

import java.util.List;

import beans.Customer;

/*
 * �ͻ�ҵ���߼���ӿ�
 */
public interface CustomerService {
	// �ͻ���Ϣչʾ
	public List<Customer> showCustomer();

	// ��ҳ��ѯ�ͻ���Ϣ
	public List<Customer> getCoustomerByPage(String nowPage, String pageSize);

	// ��ȡ��ҳ��
	public int getAllpage(String pageSize);

	// �ͻ���Ϣɾ��
	public int deleCustomer(Customer customer);

	// ��ӿͻ���Ϣ
	public int addcustomer(Customer customer);

}
