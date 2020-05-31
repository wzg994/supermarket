package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.User;
import services.UserService;
import services.UserServiceImpl;

@WebServlet("/updateAdmin")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 进行修改管理员信息
		// 创建userService对象
		UserService userService = new UserServiceImpl();
		// 根据管理员id查询管理员信息
		User adminById = userService.getAdminById(Integer.parseInt(id));

		// 设置要更新的管理员信息
		adminById.setUsername(username);
		adminById.setPassword(password);

		// 更新管理员信息
		int out = userService.updateAdmin(adminById);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// 把map的值转化为json数据传给前端
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
