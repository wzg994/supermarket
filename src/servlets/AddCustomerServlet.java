package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import services.CustomerService;
import services.CustomerServiceImpl;


@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String custel = request.getParameter("custel");
		String person = request.getParameter("person");
		String address = request.getParameter("address");

		//���������ͻ�
		// ����customerService����
		CustomerService customerService = new CustomerServiceImpl();
		// ����customer����
		Customer customer = new Customer();

		// ����customer��ֵ
		customer.setCusid(Integer.parseInt(cusid));
		customer.setCusname(cusname);
		customer.setCustel(custel);
		customer.setPerson(person);
		customer.setAddress(address);

		// �����ͻ���Ϣ
		int out = customerService.addcustomer(customer);
		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");

		// �ж��Ƿ������ɹ�
		if (out != 0) {// �����ɹ�
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
