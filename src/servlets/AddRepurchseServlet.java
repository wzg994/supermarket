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

import beans.Purchase;
import beans.Repurchase;
import beans.Stock;
import dao.PurchaseDao;
import dao.PurchaseDaoImpl;
import services.RepurchaseService;
import services.RepurchaseServiceImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/addRepurchse")
public class AddRepurchseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String purid = request.getParameter("purid");
//		String shopid = request.getParameter("shopid");
//		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
//		String shopnum = request.getParameter("shopnum");
//		String purdate = request.getParameter("purdate");
//		String supname = request.getParameter("supname");
		String reson = request.getParameter("reson");
		String mark = request.getParameter("mark");

		
		// 创建purchaseDao对象
		PurchaseDao purchaseDao = new PurchaseDaoImpl();

		// 创建退货对象
		Repurchase repurchase = new Repurchase();
		RepurchaseService repurchaseService = new RepurchaseServiceImpl();
		// 查询进货信息 根据 商品id
		Purchase purchase = purchaseDao.getPurchaseById(Integer.parseInt(purid));
		// 设置退货信息的值
		repurchase.setPurid(purchase.getPurid());
		repurchase.setShopid(Integer.parseInt(purchase.getShopid()));
		repurchase.setShopname(purchase.getShopname());
		repurchase.setShopprice(Double.parseDouble(shopprice));
		repurchase.setShopnum(purchase.getShopnum());
		repurchase.setPurdate(purchase.getPurdate());
		repurchase.setMark(purchase.getSupname());
		repurchase.setReson(reson);
		repurchase.setMark(mark);

		// 执行新增退货
		repurchaseService.addRepurchase(repurchase);

		// 更新商品库存信息
		StockService service = new StockServiceImpl();
		// 根据商品名称获取商品信息
		Stock addstock = service.getSaleByName(purchase.getShopname());
		// 获取进货商品的数量
		int shopnum1 = purchase.getShopnum();

//
////		addstock.setShopid(Integer.parseInt(purchase.getShopid()));
////		addstock.setShopname(purchase.getShopname());
		// 获取商品的原本数量
		int oldshopnum = addstock.getShopnum();
		// 退货后的商品数量
		int newshopnum = oldshopnum - shopnum1;
		// 设置退货后商品数量的值
		addstock.setShopnum(newshopnum);
		// 更新商品数量信息
		service.updateStock(addstock);
		
		// 添加退货信息
		repurchaseService.addRepurchase(repurchase);

		// 删除进货信息
		int out1 = purchaseDao.delePurchase(purchase);

		Map<String, Integer> map = new HashMap<>();
		// 判断进货信息删除是否成功
		if (out1 > 0) {// 是
			// 是在map的值为1
			map.put("type", 1);
		} else {// 不成功
				// 设置map的值为0
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
