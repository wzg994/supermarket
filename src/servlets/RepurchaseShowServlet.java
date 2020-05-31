package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Repurchase;
import services.RepurchaseService;
import services.RepurchaseServiceImpl;

@WebServlet("/repurchaseShow")
public class RepurchaseShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 前端获取值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "5";// 默认显示3条数据
		}

		// 创建service对象
		RepurchaseService service = new RepurchaseServiceImpl();
		// 查询退货信息列表
		List<Repurchase> showRepurchases = service.showRepurchase();
		// 获取退货信息类别的大小
		int size = showRepurchases.size();

		// 退货分页
		List<Repurchase> repurchasesByPage = service.getRepurchaseByPage(nowPage, pageSize);
		// 获取总页数
		int allpage = service.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("repurchasesByPage", repurchasesByPage);// 分页信息
		request.setAttribute("totalsize", size);// 总页数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页
		// 请求转发
		request.getRequestDispatcher("jsp/repurchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
