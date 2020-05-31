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

		// 进行修改销售信息
		// 创建saleDao对象
		SaleDao saleDao = new SaleDaoImpl();
		// 根据销售id查询销售信息
		Sale sale = saleDao.getSaleById(Integer.parseInt(saleid));

		// 格式化时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 设置修改的信息
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

		// 更新销售信息
		int out = saleDao.updateSale(sale);

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
