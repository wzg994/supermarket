package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Purchase;
import services.PurchaseService;
import services.PurchaseServiceImpl;

@WebServlet("/purchaseShow")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "5";// Ĭ����ʾ3������
		}
		// ������������
		PurchaseService purchaseService = new PurchaseServiceImpl();

		// ���в�ѯ ��ȡ��������
		List<Purchase> purchases = purchaseService.showPurchase();

		// ��ҳ��ѯ������������
		List<Purchase> purchasesBypage = purchaseService.getPurchaseByPage(nowPage, pageSize);
		// ��ȡ������Ϣ��С
		int size = purchases.size();

		// ��ȡ��ҳ��
		int allpage = purchaseService.getAllPage(pageSize);

		// ���뵽��������
		request.setAttribute("purchasesBypage", purchasesBypage);// ��ҳ��ѯ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת������ҳ
		request.getRequestDispatcher("jsp/purchase.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
