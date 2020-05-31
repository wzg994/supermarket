package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Purchase;
import beans.Stock;
import dao.PurchaseDao;
import dao.PurchaseDaoImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/updatePurchase")
public class UpdatePurchaseServlet extends HttpServlet {
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
		String supname = request.getParameter("supname");

		// 进行修改进货信息
		// 创建purchaseDao对象
		PurchaseDao purchaseDao = new PurchaseDaoImpl();
		// 根据进货id查询进货信息
		Purchase purchaseById = purchaseDao.getPurchaseById(Integer.parseInt(purid));
		// 格式化时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 设置修改的值
		purchaseById.setShopid(shopid);
		purchaseById.setShopname(shopname);
		purchaseById.setShopprice(Double.valueOf(shopprice));
		try {
			purchaseById.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		purchaseById.setSupname(supname);

		// 更新商品库存信息
		// 创建service对象
		StockService service = new StockServiceImpl();
		// 根据商品名称查询商品信息
		Stock addstock = service.getSaleByName(purchaseById.getShopname());
		// 获取进货信息数量
		int shopnum1 = purchaseById.getShopnum();
		// 判断是否存在库存信息
		if (addstock == null) {// 不存在
			Stock stock = new Stock();
			stock.setShopname(purchaseById.getShopname());
			stock.setShopnum(purchaseById.getShopnum());
			service.addstock(stock);
			System.out.println("添加成功");
		} else {// 存在
			// 获取库存数量
			int oldshopnum = addstock.getShopnum();
			// 获取更新的信息
			int updatenum = Integer.parseInt(shopnum);
			// 获取更新的库存数量
			int newnum = updatenum - shopnum1;
			// 获取更新后的库存数量
			int newshopnum = oldshopnum + newnum;
			// 设置库存数量
			addstock.setShopnum(newshopnum);
			// 更新库存信息
			service.updateStock(addstock);
		}

		purchaseById.setShopnum(Integer.parseInt(shopnum));

		// 创建stockService对象
		StockService stockService = new StockServiceImpl();
		// 获取库存信息列表
		List<Stock> showStocks = stockService.showStocks();
		// 获取商品库存信息不足的信息
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		// 判断库存信息列表是否为空
		if (stockNum.isEmpty()) {// 为空
			// 设置预警信息为空(或者移除预警信息)
			request.getSession().setAttribute("msg", "");
		}

		// 更新进货信息
		int out = purchaseDao.updatePurchase(purchaseById);

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
