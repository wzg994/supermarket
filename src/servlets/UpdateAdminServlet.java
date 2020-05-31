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
		// ����ǰ�˴�������ֵ
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// �����޸Ĺ���Ա��Ϣ
		// ����userService����
		UserService userService = new UserServiceImpl();
		// ���ݹ���Աid��ѯ����Ա��Ϣ
		User adminById = userService.getAdminById(Integer.parseInt(id));

		// ����Ҫ���µĹ���Ա��Ϣ
		adminById.setUsername(username);
		adminById.setPassword(password);

		// ���¹���Ա��Ϣ
		int out = userService.updateAdmin(adminById);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// ��map��ֵת��Ϊjson���ݴ���ǰ��
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
