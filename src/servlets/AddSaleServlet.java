package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sale;
import services.SaleService;
import services.SaleServiceImpl;

@WebServlet("/addSale")
public class AddSaleServlet extends HttpServlet {
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

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// �������������Ϣ
		SaleService saleService = new SaleServiceImpl();
		Sale sale = new Sale();

		// ����������Ϣ��ֵ
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

		// ִ������������Ϣ
		int out = saleService.addSale(sale);

		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");

		// �ж����������Ƿ�ɹ�
		if (out != 0) {
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
