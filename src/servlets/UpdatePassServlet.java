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

@WebServlet("/updatePass")
public class UpdatePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String oldP = request.getParameter("oldP");
		String newP = request.getParameter("newP");
		// 获取User对象
		User user = (User) request.getSession().getAttribute("user");
		// 获取staff对象
		Staff staff = (Staff) request.getSession().getAttribute("staff");

		// 判断user对象是否为空
		if (user != null) {// 为空
			// 创建userService对象
			UserService userService = new UserServiceImpl();

			// 判断前端输入的旧密码是否是原来的密码
			if (!oldP.equals(user.getPassword())) {// 不一致，返回
				response.getWriter().print(-1);
				return;
			}
			// 判断前端输入的新旧密码是否一致
			if (oldP.equals(newP)) {// 一致，返回
				response.getWriter().print(2);
				return;
			}
			// 设置新密码
			user.setPassword(newP);
			// 更新管理员信息
			int out = userService.updateAdminPassword(user);
			// 移除user对象
			request.getSession().removeAttribute("user");
			//
			response.getWriter().print(out);
		}

		// 判断staff对象是否为空
		if (staff != null) {// 不为空
			// 创建staffService对象
			StaffService staffService = new StaffServiceImpl();
			// 判断前端输入的旧密码是否是原来的密码
			if (!oldP.equals(staff.getStaffpassword())) {// 不一致，返回
				response.getWriter().print(-1);
				return;
			}
			// 判断前端输入的新旧密码是否一致
			if (oldP.equals(newP)) {// 一致，返回
				response.getWriter().print(2);
				return;
			}
			// 设置新密码
			staff.setStaffpassword(newP);
			// 更新员工信息
			int out = staffService.updatePassword(staff);
			// 移除staff对象
			request.getSession().removeAttribute("staff");
			response.getWriter().print(out);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
