package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/stockShow")
public class StockShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˻�ȡֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("ҳ����С��" + pageSize);
		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "5";// Ĭ����ʾ3������
		}

		// ����service����
		StockService service = new StockServiceImpl();
		// ��ѯ�����Ϣ�б�
		List<Stock> stocks = service.showStocks();
		// ��ȡ�����Ϣ�б��Ĵ�С
		int size = stocks.size();
		// ��ҳ��ѯ�����Ϣ�б�
		List<Stock> stockByPage = service.getStockByPage(nowPage, pageSize);
		// ��ȡ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("stockByPage", stockByPage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ
		// ����ת��
		request.getRequestDispatcher("jsp/stock.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}