package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import beans.Type;
import services.ProductSerive;
import services.ProductSeriveImpl;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/productshow")
public class ProductshowSerlvet extends HttpServlet {
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

		// ����ProductSercice����
		ProductSerive sercice = new ProductSeriveImpl();

		// ����typeService����
		TypeService typeService = new TypeServiceImpl();
		// ��ѯ������Ʒ����
		List<Type> showType = typeService.showType();

		// ���в�ѯ ��ȡ��Ʒ�б�
		List<Product> showproducts = sercice.showProduct();
		// ��ȡ��Ϣ�ܴ�С
		int size = showproducts.size();

		// ��ҳ��ѯ��Ʒ��Ϣ
		List<Product> shopsBypage = sercice.getProductByPage(nowPage, pageSize);
		// ��ȡ��ҳ��
		int allpage = sercice.getAllpage(pageSize);

		// �ŵ�request������
		request.setAttribute("protype", showType);// ��Ʒ�����Ϣ
		request.setAttribute("shopsBypage", shopsBypage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ��ҳ��
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת������ҳ
		request.getRequestDispatcher("/jsp/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
