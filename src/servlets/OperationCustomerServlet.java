package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

@WebServlet("/operationCustomer")
public class OperationCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String cusid = request.getParameter("cusid");
		String operation = request.getParameter("operation");

		// 创建customerDao对象
		CustomerDao customerDao = new CustomerDaoImpl();

		// 获取当前url的地址
		String url = request.getHeader("Referer");
		// 根据id查询客户的信息
		Customer customer = customerDao.getCustomerById(Integer.parseInt(cusid));

		// 判断客户是否存在
		if (customer == null) {// 不存在
			System.out.println("查询不存在");
		} else {// 存在
				// 判断操作数
			if (operation.equals("4")) {// 操作数为4，执行删除操作
				// 删除客户
				customerDao.deleCustomer(customer);
				// 重定向
				response.sendRedirect(url);
			} else if (operation.equals("2")) {// 操作数为2，执行更新操作
				// 更新操作
				request.setAttribute("customer", customer);
				// 请求转发到指定页面
				request.getRequestDispatcher("jsp/update/updateCustomer.jsp").forward(request, response);
			} else if (operation.equals("5")) {// 操作数为5.执行 查询操作
				// 根据客户信息查询客户信息
				List<Customer> selectCustomer = customerDao.selectCustomer(customer);
				// 将查询的数据放到作用域
				request.setAttribute("customer", selectCustomer);
				// 将数据请求转发到指定页面
				request.getRequestDispatcher("jsp/look/lookCustomer.jsp").forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
