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
		// 前端接收值
		String operation = request.getParameter("operation");

		// 判断操作数的值
		if (operation.equals("1")) {// 操作数为1，获取员工信息
			// 获取员工的名字
			String name = request.getParameter("staffname");
			// 创建staffService对象
			StaffService staffService = new StaffServiceImpl();
			// 根据员工名字查询员工信息
			Staff staffByName = staffService.getStaffByName(name);
			// 将员工信息数据放到作用域中
			request.setAttribute("staff", staffByName);
			// 请求转发
			request.getRequestDispatcher("jsp/staffbaseinf.jsp").forward(request, response);

		} else if (operation.equals("2")) {// 操作数为2，获取管理员信息
			// 从前端获取管理员名称
			String name = request.getParameter("username");
			// 创建userService对象
			UserService userService = new UserServiceImpl();
			// 根据管理员名称查询管理员信息
			User adminByName = userService.getAdminByName(name);
			// 将管理员信息放到作用域
			request.setAttribute("admin", adminByName);
			// 请求转发
			request.getRequestDispatcher("jsp/user/adminbaseinfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
