package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;
import dao.StockDao;
import dao.StockDaoImpl;

@WebServlet("/operationStock")
public class OperationStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String shopid = request.getParameter("shopid");
		String operation = request.getParameter("operation");

		// ����stockDao����
		StockDao stockDao = new StockDaoImpl();
		// ��ȡ��ǰ�����url��ַ
		String url = request.getHeader("Referer");

		// ��ѯ�����Ϣ
		Stock stock = stockDao.getStockById(Integer.parseInt(shopid));
		// �жϿ����Ϣ�Ƿ����
		if (stock == null) {// ������
			System.out.println("��ѯ������");
		} else {
			// �жϲ�������ֵ
			if (operation.equals("4")) {// ������Ϊ4��ִ��ɾ������
				// ɾ�������Ϣ
				stockDao.deleSale(stock);
				// �ض���
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���
				// �����ݷŵ�������
				request.setAttribute("stock", stock);
				// ����ת��
				request.getRequestDispatcher("jsp/update/updateStock.jsp").forward(request, response);
			} else if (operation.equals("5")) {// ������Ϊ2��ִ�в�ѯ����
				// ��ѯ�����Ϣ�б�
				List<Stock> selectSale = stockDao.selectStock(stock);
				// �����ݷŵ�������
				request.setAttribute("stock", selectSale);
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookStock.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
