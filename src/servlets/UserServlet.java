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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String msg = request.getParameter("msg");
		String username = request.getParameter("username");

		// ����stockService����
		StockService stockService = new StockServiceImpl();
		// ��ѯ�����Ϣ�б�
		List<Stock> showStocks = stockService.showStocks();
		// ��ѯ��������������Ϣ�б�
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		// �ж���Ϣ�б��Ƿ�Ĵ�С
		if (stockNum.size() != 0) {// ��Ϊ0
			// ����Ԥ����Ϣ
			// request.getSession().setAttribute("msg", "���棺����Ʒ��治�㣬�뼰ʱ��ӣ�");
			msg = "���棺����Ʒ��治�㣬�뼰ʱ��ӣ�";

			response.getWriter().print(msg);
		} else {// Ϊ0
			System.out.println("û����Ʒ��治��");
			msg = "";
			response.getWriter().print(msg);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
