package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sale;
import dao.SaleDao;
import dao.SaleDaoImpl;

@WebServlet("/operationSale")
public class OperationSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String saleid = request.getParameter("saleid");
		String operation = request.getParameter("operation");

		// ����saleDao����
		SaleDao saleDao = new SaleDaoImpl();

		// ��ȡ��ǰ�����url��ַ
		String url = request.getHeader("Referer");
		// ��������id��ѯ������Ϣ
		Sale sale = saleDao.getSaleById(Integer.parseInt(saleid));
		// �ж�������Ϣ�Ƿ�Ϊ����
		if (sale == null) {// ������
			System.out.println("��ѯ������");
		} else {// ����
				// �жϲ�������ֵ
			if (operation.equals("4")) {// ������Ϊ4��ִ��ɾ������
				// ɾ��������Ϣ
				saleDao.deleSale(sale);
				// �ض���
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���
				// �����ݷŵ�������
				request.setAttribute("sale", sale);
				// ����ת��
				request.getRequestDispatcher("jsp/update/updateSale.jsp").forward(request, response);
			} else if (operation.equals("5")) {// ������Ϊ5��ִ�в�ѯ����
				// ��ѯ��Ϣ
				List<Sale> selectSale = saleDao.selectSales(sale);
				// �����ݷŵ�������
				request.setAttribute("sale", selectSale);
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookSale.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
