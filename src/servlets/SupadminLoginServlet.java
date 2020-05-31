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
		// 接收前端的值
		String supname = request.getParameter("supname");
		String password = request.getParameter("suppassword");

		// 创建supadminService对象
		SupadminService supadminService = new SupadminServiceImpl();
		// 超级管理员登录
		Supadmin supadmin = supadminService.login(supname, password);

		// 判断超级管理员名字是否存在
		if (!supadminService.exitName(supname)) {// 不存在
			// 设置提示信息
			request.setAttribute("supnameErr", "用户名错误");
			// 请求转发
			request.getRequestDispatcher("/jsp/suplogin.jsp").forward(request, response);
			return;
		}

		// 判断超级管理员信息是否存在
		if (supadmin != null) {// 存在
			// 把supadmin放到session作用域
			request.getSession().setAttribute("supadmin", supadmin);
			// 请求转发
			response.sendRedirect(request.getContextPath() + "/jsp/supmanger/supermenu.jsp");
		} else {// 不存在
				// 设置提示信息
			request.setAttribute("suppasswordErr", "密码错误");
			// 请求转发
			request.getRequestDispatcher("/jsp/suplogin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
