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

import beans.Repurchase;
import dao.RepurchaseDao;
import dao.RepurchaseDaoImpl;

@WebServlet("/updateRepurchase")
public class UpdateRepurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String purid = request.getParameter("purid");
		String shopid = request.getParameter("shopid");
		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
		String shopnum = request.getParameter("shopnum");
		String purdate = request.getParameter("purdate");
		String reson = request.getParameter("reson");
		String mark = request.getParameter("mark");

		// 进行修改退货信息
		// 创建repurchaseDao对象
		RepurchaseDao repurchaseDao = new RepurchaseDaoImpl();
		// 根据退货id查询退货信息
		Repurchase repurchaseById = repurchaseDao.getRepurchaseById(Integer.parseInt(purid));

		// 格式化时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// 设置修改的值
		repurchaseById.setPurid(Integer.parseInt(purid));
		repurchaseById.setShopid(Integer.parseInt(shopid));
		repurchaseById.setShopname(shopname);
		repurchaseById.setShopnum(Integer.parseInt(shopnum));
		try {
			repurchaseById.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		repurchaseById.setShopprice(Double.parseDouble(shopprice));
		repurchaseById.setReson(reson);
		repurchaseById.setMark(mark);

		// 更新退货信息
		int out = repurchaseDao.updateRepurchase(repurchaseById);

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
