package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Supplier;
import dao.SupplierDao;
import dao.SupplierDaoImpl;

@WebServlet("/updateSupplie")
public class UpdateSupplieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String supid = request.getParameter("supid");
		String supname = request.getParameter("supname");
		String suptel = request.getParameter("suptel");
		String person = request.getParameter("supperson");
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		// 进行修改供应商信息
		// 创建supplierDao对象
		SupplierDao supplierDao = new SupplierDaoImpl();
		// 根据供应商id查询供应商信息
		Supplier supplier1 = supplierDao.getSupById(Integer.parseInt(supid));

		// 设置修改的值
		supplier1.setSupname(supname);
		supplier1.setSuptel(suptel);
		supplier1.setPerson(person);
		supplier1.setAddress(address);
		supplier1.setEmail(email);

		// 更新供应商信息
		int out = supplierDao.updateSupplier(supplier1);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// 把map的值转化为json数据传给前端
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
