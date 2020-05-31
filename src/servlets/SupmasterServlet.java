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
		// 前端获取值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		String operation = request.getParameter("operation");

		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "4";// 默认4显示条数据
		}

		// 判断操作数的值
		if (operation.equals("2")) {// 操作数为2，查看员工信息
			// 创建staffService对象
			StaffService staffService = new StaffServiceImpl();
			// 查询员工信息列表
			List<Staff> showStaffs = staffService.showStaffs();
			// 获取员工信息列表大小
			int size = showStaffs.size();
			// 分页查询员工信息
			List<Staff> staffByPage = staffService.getStaffByPage(nowPage, pageSize);
			// 获取总页数
			int allpage = staffService.getAllpage(pageSize);

			// 加入到作用域中
			request.setAttribute("staffsBypage", staffByPage);// 分页信息
			request.setAttribute("totalsize", size);// 总条数
			request.setAttribute("allpage", allpage);// 总页数
			request.setAttribute("nowPage", nowPage);// 当前页
			// 请求转发
			request.getRequestDispatcher("jsp/supmanger/staff.jsp").forward(request, response);
		} else if (operation.equals("3")) {// 操作数为3，查看管理员信息
			// 创建userService对象
			UserService userService = new UserServiceImpl();
			// 查询管理员信息列表
			List<User> showUser = userService.showUser();
			// 获取管理员信息的大小
			int size = showUser.size();
			// 分页查询管理员信息列表
			List<User> adminByPage = userService.getAdminByPage(nowPage, pageSize);
			// 获取总页数
			int allpage = userService.getAllpage(pageSize);

			// 加入到作用域中
			request.setAttribute("users", adminByPage);
			request.setAttribute("totalsize", size);// 总条数
			request.setAttribute("allpage", allpage);// 总页数
			request.setAttribute("nowPage", nowPage);// 当前页
			// 请求转发
			request.getRequestDispatcher("jsp/supmanger/admininfo.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
