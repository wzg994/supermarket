package servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Purchase;
import beans.Repurchase;
import beans.Stock;
import services.PurchaseService;
import services.PurchaseServiceImpl;
import services.RepurchaseService;
import services.RepurchaseServiceImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/operationPurchase")
public class OperationPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从前端获取值
		String purid = request.getParameter("purid");
		// 接收操作数
		String operation = request.getParameter("operation");

		// 创建对象
		PurchaseService purchaseService = new PurchaseServiceImpl();

		// 获取请求的前的路径
		String url = request.getHeader("Referer");
		// 判断进货id是否存在
		if (purid == null) {// 不存在
			// 判断操作数的值
			if (operation.equals("3")) {// 操作数为3，执行模糊查操作
				// 获取前端商品名称
				String shopname = request.getParameter("shopname");
				// 根据商品名称模糊查询进货信息
				List<Purchase> selectPurchaseByName = purchaseService.selectPurchaseByName(shopname);
				// 判断查询到的进货信息的大小
				if (selectPurchaseByName.size() == 0) {// 为0,
					// 设置提示信息
					request.setAttribute("purchasemsg", "没有符合条件的信息");
				} else {// 不为0
						// 将数据放到作用域
					request.setAttribute("purchases", selectPurchaseByName);
				}
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookpurchase.jsp").forward(request, response);
			}
		} else {// 存在
				// 查询商品信息 根据 商品id
			Purchase purchase = purchaseService.getPurchaseId(Integer.parseInt(purid));
			// 判断进货信息是否存在
			if (purchase == null) {// 不存在
				System.out.println("查询不存在");
			} else {// 存在
					// 判断操作数的值
				if (operation.equals("1")) {// 操作数为1，执行进货信息的删除操作和退货信息的添加操作，更新商品库存
					// 创建退单信息对象
					RepurchaseService repurchaseService = new RepurchaseServiceImpl();
					Repurchase repurchase = new Repurchase();
					// 设置退单信息的值
					repurchase.setPurid(purchase.getPurid());
					repurchase.setShopid(Integer.parseInt(purchase.getShopid()));
					repurchase.setShopname(purchase.getShopname());
					repurchase.setShopprice(purchase.getShopprice());
					repurchase.setShopnum(purchase.getShopnum());
					repurchase.setPurdate(purchase.getPurdate());
					repurchase.setMark(purchase.getSupname());

					// 商品库存信息的更新
					StockService service = new StockServiceImpl();
					// 根据商品名称查询商品库存
					Stock addstock = service.getSaleByName(purchase.getShopname());

					// 判断商品信息是否存在
					if (addstock == null) {// 不存在
						Stock stock = new Stock();
						// 设置库存信息的值
						stock.setShopname(purchase.getShopname());
						stock.setShopnum(purchase.getShopnum());
						// 添加库存信息
						service.addstock(stock);
					}

					// 获取进货信息的商品数量
					int shopnum1 = purchase.getShopnum();
					// 获取商品库存数量
					int oldshopnum = addstock.getShopnum();
					// 获取退货后的商品数量
					int newshopnum = oldshopnum - shopnum1;
					// 设置商品库存数量
					addstock.setShopnum(newshopnum);
					// 更新商品库存数量
					service.updateStock(addstock);
					// 添加退货信息
					repurchaseService.addRepurchase(repurchase);
					// 删除进货信息
					purchaseService.delePurchase(purchase);
					// 重定向
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// 操作数为2，执行更新操作
					// 将数据放到作用域
					request.setAttribute("purchase", purchase);
					// 请求转发
					request.getRequestDispatcher("jsp/update/updatePurchase.jsp").forward(request, response);
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
