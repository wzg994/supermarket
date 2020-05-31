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

@WebServlet("/operationmaster")
public class OperationSupermasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String operation = request.getParameter("operation");

		// �жϲ�������ֵ
		if (operation.equals("1")) {// ������Ϊ1����ȡԱ����Ϣ
			// ��ȡԱ��������
			String name = request.getParameter("staffname");
			// ����staffService����
			StaffService staffService = new StaffServiceImpl();
			// ����Ա�����ֲ�ѯԱ����Ϣ
			Staff staffByName = staffService.getStaffByName(name);
			// ��Ա����Ϣ���ݷŵ���������
			request.setAttribute("staff", staffByName);
			// ����ת��
			request.getRequestDispatcher("jsp/staffbaseinf.jsp").forward(request, response);

		} else if (operation.equals("2")) {// ������Ϊ2����ȡ����Ա��Ϣ
			// ��ǰ�˻�ȡ����Ա����
			String name = request.getParameter("username");
			// ����userService����
			UserService userService = new UserServiceImpl();
			// ���ݹ���Ա���Ʋ�ѯ����Ա��Ϣ
			User adminByName = userService.getAdminByName(name);
			// ������Ա��Ϣ�ŵ�������
			request.setAttribute("admin", adminByName);
			// ����ת��
			request.getRequestDispatcher("jsp/user/adminbaseinfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
