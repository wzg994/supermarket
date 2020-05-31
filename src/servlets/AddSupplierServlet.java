package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import services.SupplierService;
import services.SupplierServiceImpl;

@WebServlet("/addSupplier")
public class AddSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String supid = request.getParameter("supid");
		String supname = request.getParameter("supname");
		String suptel = request.getParameter("suptel");
		String person = request.getParameter("supperson");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		System.out.println("添加的供应商为：" + supname + " " + suptel + " " + person + "" + "" + address + "" + email);

		// 进行添加供应商
		SupplierService supplierService = new SupplierServiceImpl();
		Supplier supplier1 = new Supplier();
		// 设置供应的值
		supplier1.setSupid(Integer.parseInt(supid));
		supplier1.setSupname(supname);
		supplier1.setSuptel(suptel);
		supplier1.setPerson(person);
		supplier1.setAddress(address);
		supplier1.setEmail(email);
		// 新增供应商
		int out = supplierService.addSupplier(supplier1);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");
		// 判断新增供应商是否成功
		if (out != 0) {// 成功
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
