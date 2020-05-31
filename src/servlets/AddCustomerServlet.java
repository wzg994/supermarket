package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;
import services.CustomerService;
import services.CustomerServiceImpl;


@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String custel = request.getParameter("custel");
		String person = request.getParameter("person");
		String address = request.getParameter("address");

		//进行新增客户
		// 创建customerService对象
		CustomerService customerService = new CustomerServiceImpl();
		// 创建customer对象
		Customer customer = new Customer();

		// 设置customer的值
		customer.setCusid(Integer.parseInt(cusid));
		customer.setCusname(cusname);
		customer.setCustel(custel);
		customer.setPerson(person);
		customer.setAddress(address);

		// 新增客户信息
		int out = customerService.addcustomer(customer);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");

		// 判断是否新增成功
		if (out != 0) {// 新增成功
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
