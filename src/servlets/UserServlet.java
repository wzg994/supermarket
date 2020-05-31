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

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String msg = request.getParameter("msg");
		String username = request.getParameter("username");

		// 创建stockService对象
		StockService stockService = new StockServiceImpl();
		// 查询库存信息列表
		List<Stock> showStocks = stockService.showStocks();
		// 查询库存数量不足的信息列表
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		// 判断信息列表是否的大小
		if (stockNum.size() != 0) {// 不为0
			// 设置预警信息
			// request.getSession().setAttribute("msg", "警告：有商品库存不足，请及时添加！");
			msg = "警告：有商品库存不足，请及时添加！";

			response.getWriter().print(msg);
		} else {// 为0
			System.out.println("没有商品库存不足");
			msg = "";
			response.getWriter().print(msg);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
