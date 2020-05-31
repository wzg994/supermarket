package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

@WebServlet("/operationCustomer")
public class OperationCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String cusid = request.getParameter("cusid");
		String operation = request.getParameter("operation");

		// ����customerDao����
		CustomerDao customerDao = new CustomerDaoImpl();

		// ��ȡ��ǰurl�ĵ�ַ
		String url = request.getHeader("Referer");
		// ����id��ѯ�ͻ�����Ϣ
		Customer customer = customerDao.getCustomerById(Integer.parseInt(cusid));

		// �жϿͻ��Ƿ����
		if (customer == null) {// ������
			System.out.println("��ѯ������");
		} else {// ����
				// �жϲ�����
			if (operation.equals("4")) {// ������Ϊ4��ִ��ɾ������
				// ɾ���ͻ�
				customerDao.deleCustomer(customer);
				// �ض���
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���
				// ���²���
				request.setAttribute("customer", customer);
				// ����ת����ָ��ҳ��
				request.getRequestDispatcher("jsp/update/updateCustomer.jsp").forward(request, response);
			} else if (operation.equals("5")) {// ������Ϊ5.ִ�� ��ѯ����
				// ���ݿͻ���Ϣ��ѯ�ͻ���Ϣ
				List<Customer> selectCustomer = customerDao.selectCustomer(customer);
				// ����ѯ�����ݷŵ�������
				request.setAttribute("customer", selectCustomer);
				// ����������ת����ָ��ҳ��
				request.getRequestDispatcher("jsp/look/lookCustomer.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
