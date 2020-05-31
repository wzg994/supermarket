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
		// ����ǰ�˵�ֵ
		String supid = request.getParameter("supid");
		String supname = request.getParameter("supname");
		String suptel = request.getParameter("suptel");
		String person = request.getParameter("supperson");
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		// �����޸Ĺ�Ӧ����Ϣ
		// ����supplierDao����
		SupplierDao supplierDao = new SupplierDaoImpl();
		// ���ݹ�Ӧ��id��ѯ��Ӧ����Ϣ
		Supplier supplier1 = supplierDao.getSupById(Integer.parseInt(supid));

		// �����޸ĵ�ֵ
		supplier1.setSupname(supname);
		supplier1.setSuptel(suptel);
		supplier1.setPerson(person);
		supplier1.setAddress(address);
		supplier1.setEmail(email);

		// ���¹�Ӧ����Ϣ
		int out = supplierDao.updateSupplier(supplier1);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// ��map��ֵת��Ϊjson���ݴ���ǰ��
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
