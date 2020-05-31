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
		// 接收前端传过来的值
		String adminname = request.getParameter("adminname");
		String adminpassword = request.getParameter("adminpassword");

		// 进行注册管理员
		UserService userService = new UserServiceImpl();
		User user = new User();
		// 设置管理员信息
		user.setUsername(adminname);
		user.setPassword(adminpassword);

		// 执行注册
		int out = userService.register(user);

		// 判断
		if (out > 0) {
			// 重定向到登入界面
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		} else {// 用户已经存在
				// 设置提示信息放到作用域
			request.setAttribute("message", "用户已经存在,请重新注册!");
			// 请求转发
			request.getRequestDispatcher("jsp/adminregister.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
