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
		// 接收前端的值
		String quit = request.getParameter("operatioan");
		// 判断退出的值
		if (quit.equals("1")) {// 退出的值为1，管理员退出
			// 移除管理员对象
			request.getSession().removeAttribute("user");
			// 移除提示信息
			request.getSession().removeAttribute("msg");
			// 请求转发
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if (quit.equals("2")) {// 退出的值为1，员工退出
			// 移除员工对象
			request.getSession().removeAttribute("staff");
			// 请求转发
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else if (quit.equals("3")) {// 退出的值为1，超级管理员退出
			// 移除超级管理员对象
			request.getSession().removeAttribute("supadmin");
			// 请求转发
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
