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

@WebServlet("/operationAdmin")
public class OperationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String adminid = request.getParameter("id");
		String operation = request.getParameter("operation");

		// 创建userService对象
		UserService userService = new UserServiceImpl();

		// 获取当前url的地址
		String url = request.getHeader("Referer");

		// 判断管理员id是否存在
		if (adminid == null) {// 存在
			System.out.println("查询不存在");
			// 判断前端的操作数是什么
			if (operation.equals("5")) {// 操作数为5 查询管理员信息
				//获取前端的值
				String adminname = request.getParameter("username");
				// 根据名字查询管理员信息
				List<User> adminByNames = userService.getAdminByNames(adminname);
				// 判断是否有查询到的管理员信息
				if (adminByNames.size() == 0) {// 没有查询到
					// 设置提示信息传给前端
					request.setAttribute("adminmsg", "没有符合条件的管理员信息");
				} else {// 查询到
					// 设置查询到的信息传给前端
					request.setAttribute("admin", adminByNames);
				}
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookAdmin.jsp").forward(request, response);
			}
		} else {// id不存在
			// 根据id获取管理员信息
			User adminById = userService.getAdminById(Integer.parseInt(adminid));
			// 判断操作数的数值
			if (operation.equals("4")) {// 操作数等于4 ，执行删除操作
				// 删除管理员
				userService.deleAdmin(adminById);
				// 重定向页面
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// 操作数为2，执行更新操作

				// 将查询到的管理员信息放到作用域
				request.setAttribute("admin", adminById);
				// 将数据请求转发到指定页面
				request.getRequestDispatcher("jsp/update/updateAdmin.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
