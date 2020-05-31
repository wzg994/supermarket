package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import services.SupplierService;
import services.SupplierServiceImpl;

@WebServlet("/supplierShow")
public class SupplierShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "3";// Ĭ����ʾ3������
		}

		// ����service����
		SupplierService service = new SupplierServiceImpl();

		// ���в�ѯ ��ȡ��Ӧ���б�
		List<Supplier> showsuppliers = service.showSupplier();
		// ��ȡ��Ӧ���б��С
		int size = showsuppliers.size();
		// ��ҳ��ѯ��Ӧ���б�
		List<Supplier> suppliersBypage = service.getSupplierByPage(nowPage, pageSize);
		// ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("supplierBypage", suppliersBypage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת������ҳ
		request.getRequestDispatcher("jsp/supplier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
