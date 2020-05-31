package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import dao.TypeDao;
import dao.TypeDaoImpl;

@WebServlet("/operationType")
public class OperationTypeServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String typeid = request.getParameter("typeid");
		String operation = request.getParameter("operation");

		// ����typeDao����
		TypeDao typeDao = new TypeDaoImpl();
		// ��ȡ��ǰ�����url��ַ
		String url = request.getHeader("Referer");
		// ��������id��ȡ��Ʒ������Ϣ
		Type type = typeDao.getTypeById(Integer.parseInt(typeid));
		// �ж�������Ϣ�Ƿ����
		if (type == null) {// ������
			System.out.println("��ѯ������");
		} else {// ����
				// �жϲ�������ֵ
			if (operation.equals("4")) {// ������Ϊ4��ɾ��
				// ɾ��������Ϣ
				typeDao.deleType(type);
				// �ض���
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// ������Ϊ2������
				// �����ݷŵ�������
				request.setAttribute("type", type);
				// ����ת��
				request.getRequestDispatcher("jsp/update/updateType.jsp").forward(request, response);
			} else if (operation.equals("5")) {// ������Ϊ5����ѯ��Ʒ��Ϣ
				// ����������Ϣ��ѯ������Ϣ���
				List<Type> selectType = typeDao.selectType(type);
				// �����ݷŵ�������
				request.setAttribute("type", selectType);
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookType.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
