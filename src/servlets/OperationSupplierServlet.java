package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import dao.SupplierDao;
import dao.SupplierDaoImpl;

@WebServlet("/operationSupplier")
public class OperationSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ǰ�˻�ȡֵ
		String supplierid = request.getParameter("supplierId");
		// ���ղ�����
		String operation = request.getParameter("operation");

		// ����supplierDao����
		SupplierDao supplierDao = new SupplierDaoImpl();

		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");
		// �жϹ�Ӧ��id�Ƿ����
		if (supplierid == null) {// ������
			// ��ȡ��Ӧ������
			String supname = request.getParameter("supname");
			// �жϲ�������ֵ
			if (operation.equals("5")) {// ������Ϊ5��ִ��ģ����ѯ
				// ���ݹ�Ӧ������ģ����ѯ��Ӧ����Ϣ�б�
				List<Supplier> selectSupplier = supplierDao.getSupplier(supname);
				// �жϹ�Ӧ����Ϣ�б�Ĵ�С
				if (selectSupplier.size() == 0) {// Ϊ0
					// ������ʾ��Ϣ�ŵ�ǰ��
					request.setAttribute("suppliermsg", "��ѯ������");
				} else {
					// �����ݷŵ�������
					request.setAttribute("supplier", selectSupplier);
				}
				// ����ת��
				request.getRequestDispatcher("jsp/look/looksupplier.jsp").forward(request, response);
			}
		} else {
			// ��ѯ���ݹ�Ӧ����Ϣ id
			Supplier supplier = supplierDao.getSupById(Integer.parseInt(supplierid));
			// �жϹ�Ӧ����Ϣ�Ƿ����
			if (supplier == null) {// ������
				System.out.println("û�в�ѯ����");
			} else {// ����
					// �жϲ�������ֵ
				if (operation.equals("4")) {// ������Ϊ4,ɾ��
					// ɾ����Ӧ��
					supplierDao.deleSupplier(supplier);
					// �ض���
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// ������Ϊ2, ����
					// ��Ҫ���µ���Ϣ�ŵ�������
					request.setAttribute("supplier", supplier);
					// ����ת��
					request.getRequestDispatcher("jsp/update/updateSupplier.jsp").forward(request, response);
				} else if (operation.equals("3")) {// ������Ϊ3,����
					System.out.println("������Ϣ111");
					System.out.println("�������ֵΪ" + supplier);

					request.setAttribute("supplier", supplier);
					response.sendRedirect(url);
				}
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
