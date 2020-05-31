package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/addType")
public class AddTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String typeid = request.getParameter("typeid");
		String typename = request.getParameter("typename");

		// 进行添加商品类型
		TypeService typeService = new TypeServiceImpl();
		Type type = new Type();
		// 设置是商品类型的值
		type.setTypeid(Integer.parseInt(typeid));
		type.setTypename(typename);
		// 执行新增商品类型
		int out = typeService.addtYpe(type);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");
		// 判断新增供应商是否成功
		if (out != 0) {// 成功
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
