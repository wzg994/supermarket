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
		// 接收前端传过来的值
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//进行新增管理员
		// 创建userService对象
		UserService userService = new UserServiceImpl();
		// 创建user对象
		User user = new User();
		// 设置管理员的值
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);

		// 注册管理员
		int out = userService.register(user);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");
		// 判断注册是否成功
		if (out != 0) {// 注册成功
			// 重定向到信息界面
			response.sendRedirect(url);
		} else {// 注册失败
			System.out.println("用户已存在");
			request.setAttribute("adminerr", "用户已存在");
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
