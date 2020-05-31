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
		// 接收前端传过来的值
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

		// 进行添加销售信息
		SaleService saleService = new SaleServiceImpl();
		Sale sale = new Sale();

		// 设置销售信息的值
		sale.setSaleid(Integer.parseInt(saleid));
		sale.setShopname(shopname);
		sale.setShopprice(Double.parseDouble(shopprice));
		sale.setShopnum(Integer.parseInt(shopnum));
		sale.setTotalprice(Double.parseDouble(totalprice));
		try {
			sale.setSaledate(df.parse(saledate));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		sale.setCusid(cusid);
		sale.setCusname(cusname);
		sale.setMark(mark);

		// 执行新增销售信息
		int out = saleService.addSale(sale);

		// 获取请求的前的路径
		String url = request.getHeader("Referer");

		// 判断新增销售是否成功
		if (out != 0) {
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
