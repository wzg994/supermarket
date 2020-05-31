package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;
import dao.StockDao;
import dao.StockDaoImpl;

@WebServlet("/operationStock")
public class OperationStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String shopid = request.getParameter("shopid");
		String operation = request.getParameter("operation");

		// 创建stockDao对象
		StockDao stockDao = new StockDaoImpl();
		// 获取当前请求的url地址
		String url = request.getHeader("Referer");

		// 查询库存信息
		Stock stock = stockDao.getStockById(Integer.parseInt(shopid));
		// 判断库存信息是否存在
		if (stock == null) {// 不存在
			System.out.println("查询不存在");
		} else {
			// 判断操作数的值
			if (operation.equals("4")) {// 操作数为4，执行删除操作
				// 删除库存信息
				stockDao.deleSale(stock);
				// 重定向
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// 操作数为2，执行更新操作
				// 将数据放到作用域
				request.setAttribute("stock", stock);
				// 请求转发
				request.getRequestDispatcher("jsp/update/updateStock.jsp").forward(request, response);
			} else if (operation.equals("5")) {// 操作数为2，执行查询操作
				// 查询库存信息列表
				List<Stock> selectSale = stockDao.selectStock(stock);
				// 将数据放到作用域
				request.setAttribute("stock", selectSale);
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookStock.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
