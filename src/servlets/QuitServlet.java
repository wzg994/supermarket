package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quit")
public class QuitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String quit = request.getParameter("operatioan");
		// �ж��˳���ֵ
		if (quit.equals("1")) {// �˳���ֵΪ1������Ա�˳�
			// �Ƴ�����Ա����
			request.getSession().removeAttribute("user");
			// �Ƴ���ʾ��Ϣ
			request.getSession().removeAttribute("msg");
			// ����ת��
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if (quit.equals("2")) {// �˳���ֵΪ1��Ա���˳�
			// �Ƴ�Ա������
			request.getSession().removeAttribute("staff");
			// ����ת��
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if (quit.equals("3")) {// �˳���ֵΪ1����������Ա�˳�
			// �Ƴ���������Ա����
			request.getSession().removeAttribute("supadmin");
			// ����ת��
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
