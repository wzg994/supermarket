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

@WebServlet("/adminShow")
public class AdminShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "2";// Ĭ����ʾ3������
		}
		// ����userService����
		UserService userService = new UserServiceImpl();

		// ���в�ѯ ��ȡ����Ա�б�
		List<User> showUser = userService.showUser();
		// ��ȡ����Ա��Ϣ��С
		int size = showUser.size();

		// ��ҳ��ѯ��Ϣ
		List<User> adminByPage = userService.getAdminByPage(nowPage, pageSize);

		// ��ҳ��
		int allpage = userService.getAllpage(pageSize);

		// �ŵ�request������
		request.setAttribute("adminBypage", adminByPage);// ��ҳ��ѯ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת��
		request.getRequestDispatcher("jsp/supmanger/admininfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
