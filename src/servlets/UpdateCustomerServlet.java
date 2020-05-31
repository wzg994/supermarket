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

import beans.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String custel = request.getParameter("custel");
		String person = request.getParameter("person");
		String address = request.getParameter("address");

		// �����޸Ŀͻ���Ϣ
		// ����customerDao����
		CustomerDao customerDao = new CustomerDaoImpl();
		// ���ݿͻ�id��ѯ�ͻ���Ϣ
		Customer customer = customerDao.getCustomerById(Integer.parseInt(cusid));
		// ����Ҫ�޸ĵĿͻ���Ϣ��ֵ
		customer.setCusid(Integer.parseInt(cusid));
		customer.setCusname(cusname);
		customer.setCustel(custel);
		customer.setPerson(person);
		customer.setAddress(address);
		// ���¿ͻ���Ϣ
		int out = customerDao.updateCustomr(customer);

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
