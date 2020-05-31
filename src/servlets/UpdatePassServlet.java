package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Staff;
import beans.User;
import services.StaffService;
import services.StaffServiceImpl;
import services.UserService;
import services.UserServiceImpl;

@WebServlet("/updatePass")
public class UpdatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String oldP = request.getParameter("oldP");
		String newP = request.getParameter("newP");
		// ��ȡUser����
		User user = (User) request.getSession().getAttribute("user");
		// ��ȡstaff����
		Staff staff = (Staff) request.getSession().getAttribute("staff");

		// �ж�user�����Ƿ�Ϊ��
		if (user != null) {// Ϊ��
			// ����userService����
			UserService userService = new UserServiceImpl();

			// �ж�ǰ������ľ������Ƿ���ԭ��������
			if (!oldP.equals(user.getPassword())) {// ��һ�£�����
				response.getWriter().print(-1);
				return;
			}
			// �ж�ǰ��������¾������Ƿ�һ��
			if (oldP.equals(newP)) {// һ�£�����
				response.getWriter().print(2);
				return;
			}
			// ����������
			user.setPassword(newP);
			// ���¹���Ա��Ϣ
			int out = userService.updateAdminPassword(user);
			// �Ƴ�user����
			request.getSession().removeAttribute("user");
			//
			response.getWriter().print(out);
		}

		// �ж�staff�����Ƿ�Ϊ��
		if (staff != null) {// ��Ϊ��
			// ����staffService����
			StaffService staffService = new StaffServiceImpl();
			// �ж�ǰ������ľ������Ƿ���ԭ��������
			if (!oldP.equals(staff.getStaffpassword())) {// ��һ�£�����
				response.getWriter().print(-1);
				return;
			}
			// �ж�ǰ��������¾������Ƿ�һ��
			if (oldP.equals(newP)) {// һ�£�����
				response.getWriter().print(2);
				return;
			}
			// ����������
			staff.setStaffpassword(newP);
			// ����Ա����Ϣ
			int out = staffService.updatePassword(staff);
			// �Ƴ�staff����
			request.getSession().removeAttribute("staff");
			response.getWriter().print(out);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
