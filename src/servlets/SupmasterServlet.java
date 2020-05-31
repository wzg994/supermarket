package servlets;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/operatSupmaster")
public class SupmasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˻�ȡֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		String operation = request.getParameter("operation");

		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "4";// Ĭ��4��ʾ������
		}

		// �жϲ�������ֵ
		if (operation.equals("2")) {// ������Ϊ2���鿴Ա����Ϣ
			// ����staffService����
			StaffService staffService = new StaffServiceImpl();
			// ��ѯԱ����Ϣ�б�
			List<Staff> showStaffs = staffService.showStaffs();
			// ��ȡԱ����Ϣ�б��С
			int size = showStaffs.size();
			// ��ҳ��ѯԱ����Ϣ
			List<Staff> staffByPage = staffService.getStaffByPage(nowPage, pageSize);
			// ��ȡ��ҳ��
			int allpage = staffService.getAllpage(pageSize);

			// ���뵽��������
			request.setAttribute("staffsBypage", staffByPage);// ��ҳ��Ϣ
			request.setAttribute("totalsize", size);// ������
			request.setAttribute("allpage", allpage);// ��ҳ��
			request.setAttribute("nowPage", nowPage);// ��ǰҳ
			// ����ת��
			request.getRequestDispatcher("jsp/supmanger/staff.jsp").forward(request, response);
		} else if (operation.equals("3")) {// ������Ϊ3���鿴����Ա��Ϣ
			// ����userService����
			UserService userService = new UserServiceImpl();
			// ��ѯ����Ա��Ϣ�б�
			List<User> showUser = userService.showUser();
			// ��ȡ����Ա��Ϣ�Ĵ�С
			int size = showUser.size();
			// ��ҳ��ѯ����Ա��Ϣ�б�
			List<User> adminByPage = userService.getAdminByPage(nowPage, pageSize);
			// ��ȡ��ҳ��
			int allpage = userService.getAllpage(pageSize);

			// ���뵽��������
			request.setAttribute("users", adminByPage);
			request.setAttribute("totalsize", size);// ������
			request.setAttribute("allpage", allpage);// ��ҳ��
			request.setAttribute("nowPage", nowPage);// ��ǰҳ
			// ����ת��
			request.getRequestDispatcher("jsp/supmanger/admininfo.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
