package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/typeShow")
public class TypeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端获取值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("页数大小是" + pageSize);
		System.out.println("页数为:" + pageSize);
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "4";// 默认显示3条数据
		}

		// 创建service对象
		TypeService service = new TypeServiceImpl();
		// 查询类型列表
		List<Type> types = service.showType();
		// 获取类型列列表大小
		int size = types.size();
		// 分页查询类型列表
		List<Type> typebypage = service.getTypeByPage(nowPage, pageSize);
		// 获取总一页数
		int allpage = service.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("typesBypage", typebypage);// 分页查询
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页
		// 请求转发
		request.getRequestDispatcher("jsp/type.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
