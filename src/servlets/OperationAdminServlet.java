package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import services.UserService;
import services.UserServiceImpl;

@WebServlet("/operationAdmin")
public class OperationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String adminid = request.getParameter("id");
		String operation = request.getParameter("operation");

		// ����userService����
		UserService userService = new UserServiceImpl();

		// ��ȡ��ǰurl�ĵ�ַ
		String url = request.getHeader("Referer");

		// �жϹ���Աid�Ƿ����
		if (adminid == null) {// ����
			System.out.println("��ѯ������");
			// �ж�ǰ�˵Ĳ�������ʲô
			if (operation.equals("5")) {// ������Ϊ5 ��ѯ����Ա��Ϣ
				//��ȡǰ�˵�ֵ
				String adminname = request.getParameter("username");
				// �������ֲ�ѯ����Ա��Ϣ
				List<User> adminByNames = userService.getAdminByNames(adminname);
				// �ж��Ƿ��в�ѯ���Ĺ���Ա��Ϣ
				if (adminByNames.size() == 0) {// û�в�ѯ��
					// ������ʾ��Ϣ����ǰ��
					request.setAttribute("adminmsg", "û�з��������Ĺ���Ա��Ϣ");
				} else {// ��ѯ��
					// ���ò�ѯ������Ϣ����ǰ��
					request.setAttribute("admin", adminByNames);
				}
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookAdmin.jsp").forward(request, response);
			}
		} else {// id������
			// ����id��ȡ����Ա��Ϣ
			User adminById = userService.getAdminById(Integer.parseInt(adminid));
			// �жϲ���������ֵ
			if (operation.equals("4")) {// ����������4 ��ִ��ɾ������
				// ɾ������Ա
				userService.deleAdmin(adminById);
				// �ض���ҳ��
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���

				// ����ѯ���Ĺ���Ա��Ϣ�ŵ�������
				request.setAttribute("admin", adminById);
				// ����������ת����ָ��ҳ��
				request.getRequestDispatcher("jsp/update/updateAdmin.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
