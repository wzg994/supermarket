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

		// ��������������Ϣ
		PurchaseService purchaseService = new PurchaseServiceImpl();
		Purchase purchase = new Purchase();

		// ������Ʒ�����Ϣ
		StockService service = new StockServiceImpl();
		Stock stock = new Stock();
		// ������ǰ����ѯ��Ʒ��Ϣ�Ƿ����
		Stock addstock = service.getSaleByName(shopname);
		if (addstock == null) {// �ж��Ƿ��д��ڵ���Ʒ û��
			// ������Ʒ������Ϣ
			stock.setShopid(Integer.parseInt(shopid));
			stock.setShopname(shopname);
			stock.setShopnum(num);
			// ������Ʒ���
			service.addstock(stock);
		} else {// ��
				// ��ȡ�ɵĿ������
			int oldshopnum = addstock.getShopnum();
			// ��������������ɵ��������
			int newshopnum = oldshopnum + num;
			// �����µĿ������
			addstock.setShopnum(newshopnum);
			// ���¿����Ϣ
			service.updateStock(addstock);
		}
		// ��Ʒ���Ԥ������
		StockService stockService = new StockServiceImpl();
		// ��ȡ������Ʒ��Ϣ
		List<Stock> showStocks = stockService.showStocks();
		// ��ѯ�������
		List<Stock> stockNum = stockService.getStockNum(showStocks);
//		//�жϼ������Ƿ���ֵ
//		if (stockNum.isEmpty()) {//û��ֵ
//			//�Ƴ�msg��Ϣ
//			request.getSession().removeAttribute("msg");
//			//request.getSession().setAttribute("msg", "");
//		}

		List<Stock> stocks = service.showStocks();
		System.out.println("�����ϢΪ" + stocks);

		// ��������������Ϣ��ֵ
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		purchase.setShopid(shopid);
		purchase.setShopname(shopname);
		purchase.setShopprice(Double.parseDouble(shopprice));
		purchase.setShopnum(Integer.parseInt(shopnum));
		try {
			purchase.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		purchase.setSupname(supname);

		// ����������Ϣ
		int out = purchaseService.addPurchase(purchase);
		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");

		if (out != 0) {
			// �жϿ����Ϣ���Ƿ��������������Ʒ
			if (stockNum.isEmpty()) {// û��
				// �Ƴ�msg��Ϣ
				request.getSession().removeAttribute("msg");
			} else {
				System.out.println("����Ʒ��治��");
			}
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
