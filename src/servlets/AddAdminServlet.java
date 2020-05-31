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

@WebServlet("/addAdmin")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//������������Ա
		// ����userService����
		UserService userService = new UserServiceImpl();
		// ����user����
		User user = new User();
		// ���ù���Ա��ֵ
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);

		// ע�����Ա
		int out = userService.register(user);
		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");
		// �ж�ע���Ƿ�ɹ�
		if (out != 0) {// ע��ɹ�
			// �ض�����Ϣ����
			response.sendRedirect(url);
		} else {// ע��ʧ��
			System.out.println("�û��Ѵ���");
			request.setAttribute("adminerr", "�û��Ѵ���");
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
