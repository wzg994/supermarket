package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sale;
import services.SaleService;
import services.SaleServiceImpl;

@WebServlet("/saleShow")
public class SaleShowServlet extends HttpServlet {
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
			pageSize = "4";// 默认显示3条数据
		}
		// 创建service对象
		SaleService service = new SaleServiceImpl();
		// 查询销售信息列表
		List<Sale> sales = service.showSales();
		// 获取销售信息列表大小
		int size = sales.size();

		// 分页查询销售信息
		List<Sale> salebypage = service.getSaleByPage(nowPage, pageSize);
		// 获取总页数
		int allpage = service.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("saleBypage", salebypage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页
		// 请求转发
		request.getRequestDispatcher("jsp/sale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
