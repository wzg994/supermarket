package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import services.CustomerService;
import services.CustomerServiceImpl;

@WebServlet("/customerShow")
public class CustomerShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("页数大小是" + pageSize);
		System.out.println("页数为:" + pageSize);
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "2";// 默认显示3条数据
		}
		// 创建service对象
		CustomerService service = new CustomerServiceImpl();

		// 进行查询 获取客户列表
		List<Customer> showcustomers = service.showCustomer();
		//获取列表大小
		int size = showcustomers.size();
		// 分页查询客户信息
		List<Customer> customersBypage = service.getCoustomerByPage(nowPage, pageSize);

		// 总页数
		int allpage = service.getAllpage(pageSize);

		// 放到request作用域
		request.setAttribute("customersBypages", customersBypage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发
		request.getRequestDispatcher("jsp/customers.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
