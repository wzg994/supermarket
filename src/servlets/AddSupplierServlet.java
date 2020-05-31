package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import services.SupplierService;
import services.SupplierServiceImpl;

@WebServlet("/addSupplier")
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String supid = request.getParameter("supid");
		String supname = request.getParameter("supname");
		String suptel = request.getParameter("suptel");
		String person = request.getParameter("supperson");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		System.out.println("��ӵĹ�Ӧ��Ϊ��" + supname + " " + suptel + " " + person + "" + "" + address + "" + email);

		// ������ӹ�Ӧ��
		SupplierService supplierService = new SupplierServiceImpl();
		Supplier supplier1 = new Supplier();
		// ���ù�Ӧ��ֵ
		supplier1.setSupid(Integer.parseInt(supid));
		supplier1.setSupname(supname);
		supplier1.setSuptel(suptel);
		supplier1.setPerson(person);
		supplier1.setAddress(address);
		supplier1.setEmail(email);
		// ������Ӧ��
		int out = supplierService.addSupplier(supplier1);
		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");
		// �ж�������Ӧ���Ƿ�ɹ�
		if (out != 0) {// �ɹ�
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
