package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sale;
import services.SaleService;
import services.SaleServiceImpl;

@WebServlet("/saleShow")
public class SaleShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˻�ȡֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "4";// Ĭ����ʾ3������
		}
		// ����service����
		SaleService service = new SaleServiceImpl();
		// ��ѯ������Ϣ�б�
		List<Sale> sales = service.showSales();
		// ��ȡ������Ϣ�б��С
		int size = sales.size();

		// ��ҳ��ѯ������Ϣ
		List<Sale> salebypage = service.getSaleByPage(nowPage, pageSize);
		// ��ȡ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("saleBypage", salebypage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ
		// ����ת��
		request.getRequestDispatcher("jsp/sale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
