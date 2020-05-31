package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Purchase;
import services.PurchaseService;
import services.PurchaseServiceImpl;

@WebServlet("/purchaseShow")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "5";// 默认显示3条数据
		}
		// 创建进货对象
		PurchaseService purchaseService = new PurchaseServiceImpl();

		// 进行查询 获取进货对象
		List<Purchase> purchases = purchaseService.showPurchase();

		// 分页查询进货对象总数
		List<Purchase> purchasesBypage = purchaseService.getPurchaseByPage(nowPage, pageSize);
		// 获取进货信息大小
		int size = purchases.size();

		// 获取总页数
		int allpage = purchaseService.getAllPage(pageSize);

		// 加入到作用域中
		request.setAttribute("purchasesBypage", purchasesBypage);// 分页查询信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发到主页
		request.getRequestDispatcher("jsp/purchase.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
