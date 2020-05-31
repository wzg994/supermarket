package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/stockShow")
public class StockShowServlet extends HttpServlet {
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
			pageSize = "5";// 默认显示3条数据
		}

		// 创建service对象
		StockService service = new StockServiceImpl();
		// 查询库存信息列表
		List<Stock> stocks = service.showStocks();
		// 获取库存信息列表的大小
		int size = stocks.size();
		// 分页查询库存信息列表
		List<Stock> stockByPage = service.getStockByPage(nowPage, pageSize);
		// 获取总页数
		int allpage = service.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("stockByPage", stockByPage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页
		// 请求转发
		request.getRequestDispatcher("jsp/stock.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
