package dao;

import java.util.List;

import beans.Customer;

/*
 * �ͻ������ӿ�
 */
public interface CustomerDao {
	// ��ѯ�ͻ��б�
	public List<Customer> getCustomer();

	// ���ݿͻ�id��ѯ�ͻ���Ϣ
	public Customer getCustomerById(int id);

	// ��ҳ��ӿͻ���Ϣ
	public List<Customer> getCustomerByPage(int begin, int end);

	// ��ӿͻ�
	public int addCustomer(Customer customer);

	// �޸Ŀͻ�
	public int updateCustomr(Customer customer);

	// ɾ���ͻ�
	public int deleCustomer(Customer customer);

	// ��ѯ�ͻ���Ϣ
	public List<Customer> selectCustomer(Customer customer);

}
