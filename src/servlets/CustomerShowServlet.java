package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import services.CustomerService;
import services.CustomerServiceImpl;

@WebServlet("/customerShow")
public class CustomerShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("ҳ����С��" + pageSize);
		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "2";// Ĭ����ʾ3������
		}
		// ����service����
		CustomerService service = new CustomerServiceImpl();

		// ���в�ѯ ��ȡ�ͻ��б�
		List<Customer> showcustomers = service.showCustomer();
		//��ȡ�б��С
		int size = showcustomers.size();
		// ��ҳ��ѯ�ͻ���Ϣ
		List<Customer> customersBypage = service.getCoustomerByPage(nowPage, pageSize);

		// ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// �ŵ�request������
		request.setAttribute("customersBypages", customersBypage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת��
		request.getRequestDispatcher("jsp/customers.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
