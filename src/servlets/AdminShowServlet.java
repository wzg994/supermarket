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
		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		System.out.println("页数为:" + pageSize);
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "2";// 默认显示3条数据
		}
		// 创建userService对象
		UserService userService = new UserServiceImpl();

		// 进行查询 获取管理员列表
		List<User> showUser = userService.showUser();
		// 获取管理员信息大小
		int size = showUser.size();

		// 分页查询信息
		List<User> adminByPage = userService.getAdminByPage(nowPage, pageSize);

		// 总页数
		int allpage = userService.getAllpage(pageSize);

		// 放到request作用域
		request.setAttribute("adminBypage", adminByPage);// 分页查询信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发
		request.getRequestDispatcher("jsp/supmanger/admininfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
