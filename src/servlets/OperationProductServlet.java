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

@WebServlet("/operationProduct")
public class OperationProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String shopid = request.getParameter("proid");
		String operation = request.getParameter("operation");

		// ����productSerive����
		ProductSerive productSerive = new ProductSeriveImpl();
		// ��ȡ��ǰurl��ַ
		String url = request.getHeader("Referer");

		// �ж���Ʒid�Ƿ����
		if (shopid == null) {// �����ڣ�ִ��ģ����ѯ����
			// �жϲ�������ֵ
			if (operation.equals("5")) {// ������Ϊ5��ִ��ģ����ѯ
				// ��ȡǰ�˴���������Ʒ����
				String shopname = request.getParameter("shopname");
				// ������Ʒ���ƽ���ģ����ѯ��Ʒ��Ϣ
				List<Product> selectProductByName = productSerive.selectProductByName(shopname);
				/*
				 * �ж��Ƿ��з�����������Ʒ��Ϣ
				 */
				// �жϲ�ѯ����Ʒ��Ϣ�Ƿ�Ϊ��
				if (selectProductByName.size() == 0) {// Ϊ��
					// ������ʽ��Ϣ
					request.setAttribute("productmsg", "û�з�����������Ϣ");
				} else {// ��Ϊ��
					// ����ѯ����Ϣ�ŵ�������
					request.setAttribute("products", selectProductByName);
				}
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookproduct.jsp").forward(request, response);
			}
		} else {// ������Ʒid
			// ��ȡ��Ʒ��Ϣ
			Product product = productSerive.getProductById(Integer.parseInt(shopid));
			// �ж���Ʒ��Ϣ�Ƿ����
			if (product == null) {// ������
				System.out.println("��ѯ������");
			} else {// ����
					// �жϲ�������ֵ
				if (operation.equals("4")) {// ������Ϊ4��ִ��ɾ������
					// ɾ����Ʒ
					productSerive.deleProduct(product);
					// �ض���
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���

					// ����typeService����
					TypeService typeService = new TypeServiceImpl();
					// ��ѯ������Ʒ����
					List<Type> showType = typeService.showType();
					// �ŵ�request������
					request.setAttribute("protype", showType);
					request.setAttribute("product", product);
					// ����ת����ָ��ҳ��
					request.getRequestDispatcher("jsp/update/updateProduct.jsp").forward(request, response);
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
