package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sale;
import dao.SaleDao;
import dao.SaleDaoImpl;

@WebServlet("/operationSale")
public class OperationSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String saleid = request.getParameter("saleid");
		String operation = request.getParameter("operation");

		// 创建saleDao对象
		SaleDao saleDao = new SaleDaoImpl();

		// 获取当前请求的url地址
		String url = request.getHeader("Referer");
		// 根据销售id查询销售信息
		Sale sale = saleDao.getSaleById(Integer.parseInt(saleid));
		// 判断销售信息是否为存在
		if (sale == null) {// 不存在
			System.out.println("查询不存在");
		} else {// 存在
				// 判断操作数的值
			if (operation.equals("4")) {// 操作数为4，执行删除操作
				// 删除销售信息
				saleDao.deleSale(sale);
				// 重定向
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// 操作数为2，执行更新操作
				// 将数据放到作用域
				request.setAttribute("sale", sale);
				// 请求转发
				request.getRequestDispatcher("jsp/update/updateSale.jsp").forward(request, response);
			} else if (operation.equals("5")) {// 操作数为5，执行查询操作
				// 查询信息
				List<Sale> selectSale = saleDao.selectSales(sale);
				// 将数据放到作用域
				request.setAttribute("sale", selectSale);
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookSale.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
