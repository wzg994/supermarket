package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import beans.Purchase;
import beans.Stock;
import services.PurchaseService;
import services.PurchaseServiceImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/addPurchase")
public class AddPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String purid = request.getParameter("purid");
		String shopid = request.getParameter("shopid");
		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
		String shopnum = request.getParameter("shopnum");
		String purdate = request.getParameter("purdate");
		String supname = request.getParameter("supname");

		int num = Integer.parseInt(shopnum);

		// 进行新增进货信息
		PurchaseService purchaseService = new PurchaseServiceImpl();
		Purchase purchase = new Purchase();

		// 新增商品库存信息
		StockService service = new StockServiceImpl();
		Stock stock = new Stock();
		// 再新增前，查询商品信息是否存在
		Stock addstock = service.getSaleByName(shopname);
		if (addstock == null) {// 判断是否有存在的商品 没有
			// 设置商品库存的信息
			stock.setShopid(Integer.parseInt(shopid));
			stock.setShopname(shopname);
			stock.setShopnum(num);
			// 新增商品库存
			service.addstock(stock);
		} else {// 有
				// 获取旧的库存数量
			int oldshopnum = addstock.getShopnum();
			// 将新增的数量与旧的数量相加
			int newshopnum = oldshopnum + num;
			// 设置新的库存数量
			addstock.setShopnum(newshopnum);
			// 更新库存信息
			service.updateStock(addstock);
		}
		// 商品库存预警操作
		StockService stockService = new StockServiceImpl();
		// 获取所有商品信息
		List<Stock> showStocks = stockService.showStocks();
		// 查询库存数量
		List<Stock> stockNum = stockService.getStockNum(showStocks);
//		//判断集合中是否有值
//		if (stockNum.isEmpty()) {//没有值
//			//移除msg信息
//			request.getSession().removeAttribute("msg");
//			//request.getSession().setAttribute("msg", "");
//		}

		List<Stock> stocks = service.showStocks();
		System.out.println("库存信息为" + stocks);

		// 设置新增进货信息的值
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		purchase.setShopid(shopid);
		purchase.setShopname(shopname);
		purchase.setShopprice(Double.parseDouble(shopprice));
		purchase.setShopnum(Integer.parseInt(shopnum));
		try {
			purchase.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		purchase.setSupname(supname);

		// 新增进货信息
		int out = purchaseService.addPurchase(purchase);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");

		if (out != 0) {
			// 判断库存信息中是否有数量不足的商品
			if (stockNum.isEmpty()) {// 没有
				// 移除msg信息
				request.getSession().removeAttribute("msg");
			} else {
				System.out.println("有商品库存不足");
			}
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
