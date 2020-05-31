package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supadmin;
import services.SupadminService;
import services.SupadminServiceImpl;

@WebServlet("/supadminLogin")
public class SupadminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String supname = request.getParameter("supname");
		String password = request.getParameter("suppassword");

		// ����supadminService����
		SupadminService supadminService = new SupadminServiceImpl();
		// ��������Ա��¼
		Supadmin supadmin = supadminService.login(supname, password);

		// �жϳ�������Ա�����Ƿ����
		if (!supadminService.exitName(supname)) {// ������
			// ������ʾ��Ϣ
			request.setAttribute("supnameErr", "�û�������");
			// ����ת��
			request.getRequestDispatcher("/jsp/suplogin.jsp").forward(request, response);
			return;
		}

		// �жϳ�������Ա��Ϣ�Ƿ����
		if (supadmin != null) {// ����
			// ��supadmin�ŵ�session������
			request.getSession().setAttribute("supadmin", supadmin);
			// ����ת��
			response.sendRedirect(request.getContextPath() + "/jsp/supmanger/supermenu.jsp");
		} else {// ������
				// ������ʾ��Ϣ
			request.setAttribute("suppasswordErr", "�������");
			// ����ת��
			request.getRequestDispatcher("/jsp/suplogin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
