package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import dao.TypeDao;
import dao.TypeDaoImpl;

@WebServlet("/operationType")
public class OperationTypeServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String typeid = request.getParameter("typeid");
		String operation = request.getParameter("operation");

		// 创建typeDao对象
		TypeDao typeDao = new TypeDaoImpl();
		// 获取当前请求的url地址
		String url = request.getHeader("Referer");
		// 根据类型id获取商品类型信息
		Type type = typeDao.getTypeById(Integer.parseInt(typeid));
		// 判断类型信息是否存在
		if (type == null) {// 不存在
			System.out.println("查询不存在");
		} else {// 存在
				// 判断操作数的值
			if (operation.equals("4")) {// 操作数为4，删除
				// 删除类型信息
				typeDao.deleType(type);
				// 重定向
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// 操作数为2，更新
				// 将数据放到作用域
				request.setAttribute("type", type);
				// 请求转发
				request.getRequestDispatcher("jsp/update/updateType.jsp").forward(request, response);
			} else if (operation.equals("5")) {// 操作数为5，查询商品信息
				// 根据类型信息查询类型信息类别
				List<Type> selectType = typeDao.selectType(type);
				// 将数据放到作用域
				request.setAttribute("type", selectType);
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookType.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
