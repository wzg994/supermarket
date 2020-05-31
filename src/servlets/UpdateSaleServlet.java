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

import beans.Sale;
import dao.SaleDao;
import dao.SaleDaoImpl;

@WebServlet("/updateSale")
public class UpdateSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String saleid = request.getParameter("saleid");
		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
		String shopnum = request.getParameter("shopnum");
		String totalprice = request.getParameter("totalprice");
		String saledate = request.getParameter("saledate");
		String cusname = request.getParameter("cusname");
		String cusid = request.getParameter("cusid");
		String mark = request.getParameter("mark");

		// �����޸�������Ϣ
		// ����saleDao����
		SaleDao saleDao = new SaleDaoImpl();
		// ��������id��ѯ������Ϣ
		Sale sale = saleDao.getSaleById(Integer.parseInt(saleid));

		// ��ʽ��ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// �����޸ĵ���Ϣ
		sale.setSaleid(Integer.parseInt(saleid));
		sale.setShopname(shopname);
		sale.setShopprice(Double.parseDouble(shopprice));
		sale.setShopnum(Integer.parseInt(shopnum));
		sale.setTotalprice(Double.parseDouble(totalprice));
		try {
			sale.setSaledate(df.parse(saledate));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		sale.setCusid(cusid);
		sale.setCusname(cusname);
		sale.setMark(mark);

		// ����������Ϣ
		int out = saleDao.updateSale(sale);

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
