package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import services.UserService;
import services.UserServiceImpl;

@WebServlet("/adminRegister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String adminname = request.getParameter("adminname");
		String adminpassword = request.getParameter("adminpassword");

		// ����ע�����Ա
		UserService userService = new UserServiceImpl();
		User user = new User();
		// ���ù���Ա��Ϣ
		user.setUsername(adminname);
		user.setPassword(adminpassword);

		// ִ��ע��
		int out = userService.register(user);

		// �ж�
		if (out > 0) {
			// �ض��򵽵������
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		} else {// �û��Ѿ�����
				// ������ʾ��Ϣ�ŵ�������
			request.setAttribute("message", "�û��Ѿ�����,������ע��!");
			// ����ת��
			request.getRequestDispatcher("jsp/adminregister.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
