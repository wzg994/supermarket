package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Stock;
import dao.StockDao;
import dao.StockDaoImpl;

@WebServlet("/updateStock")
public class UpdateStockServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String shopid = request.getParameter("shopid");
		String shopname = request.getParameter("shopname");
		String shopnum = request.getParameter("shopnum");
		String shopmark = request.getParameter("shopmark");

		// 进行修改库存信息
		// 创建stockDao对象
		StockDao stockDao = new StockDaoImpl();
		// 根据商品id查询商品信息
		Stock stockById = stockDao.getStockById(Integer.parseInt(shopid));

		// 设置修改信息
		stockById.setShopid(Integer.parseInt(shopid));
		stockById.setShopname(shopname);
		stockById.setShopnum(Integer.parseInt(shopnum));
		stockById.setMark(shopmark);

		// 更新销售信息
		int out = stockDao.updateSale(stockById);

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
