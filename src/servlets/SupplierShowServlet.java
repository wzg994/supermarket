package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import services.SupplierService;
import services.SupplierServiceImpl;

@WebServlet("/supplierShow")
public class SupplierShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		System.out.println("页数为:" + pageSize);
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "3";// 默认显示3条数据
		}

		// 创建service对象
		SupplierService service = new SupplierServiceImpl();

		// 进行查询 获取供应商列表
		List<Supplier> showsuppliers = service.showSupplier();
		// 获取供应商列表大小
		int size = showsuppliers.size();
		// 分页查询供应商列表
		List<Supplier> suppliersBypage = service.getSupplierByPage(nowPage, pageSize);
		// 总页数
		int allpage = service.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("supplierBypage", suppliersBypage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发到主页
		request.getRequestDispatcher("jsp/supplier.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
