package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Product;
import dao.ProductDao;
import dao.ProductDaoImpl;

@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String proid = request.getParameter("proid");
		String proname = request.getParameter("proname");
		String proprice = request.getParameter("proprice");
		String pronum = request.getParameter("pronum");
		String prodate = request.getParameter("prodate");
		String supname = request.getParameter("supname");
		String typename = request.getParameter("typename");

		// �����޸���Ʒ
		// ����productDao����
		ProductDao productDao = new ProductDaoImpl();
		// ������Ʒid��ѯ��Ʒ��Ϣ
		Product productById = productDao.getProductById(Integer.parseInt(proid));
		// ��ʽ��ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// ������Ʒ��
		productById.setPname(proname);
		productById.setPrice(Double.parseDouble(proprice));
		productById.setPronum(Integer.parseInt(pronum));
		try {
			productById.setProdate(df.parse(prodate));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		productById.setSupname(supname);
		productById.setTypename(typename);

		// ������Ʒ��Ϣ
		int out = productDao.updateProducts(productById);

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
