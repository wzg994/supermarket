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

		
		// ����purchaseDao����
		PurchaseDao purchaseDao = new PurchaseDaoImpl();

		// �����˻�����
		Repurchase repurchase = new Repurchase();
		RepurchaseService repurchaseService = new RepurchaseServiceImpl();
		// ��ѯ������Ϣ ���� ��Ʒid
		Purchase purchase = purchaseDao.getPurchaseById(Integer.parseInt(purid));
		// �����˻���Ϣ��ֵ
		repurchase.setPurid(purchase.getPurid());
		repurchase.setShopid(Integer.parseInt(purchase.getShopid()));
		repurchase.setShopname(purchase.getShopname());
		repurchase.setShopprice(Double.parseDouble(shopprice));
		repurchase.setShopnum(purchase.getShopnum());
		repurchase.setPurdate(purchase.getPurdate());
		repurchase.setMark(purchase.getSupname());
		repurchase.setReson(reson);
		repurchase.setMark(mark);

		// ִ�������˻�
		repurchaseService.addRepurchase(repurchase);

		// ������Ʒ�����Ϣ
		StockService service = new StockServiceImpl();
		// ������Ʒ���ƻ�ȡ��Ʒ��Ϣ
		Stock addstock = service.getSaleByName(purchase.getShopname());
		// ��ȡ������Ʒ������
		int shopnum1 = purchase.getShopnum();

//
////		addstock.setShopid(Integer.parseInt(purchase.getShopid()));
////		addstock.setShopname(purchase.getShopname());
		// ��ȡ��Ʒ��ԭ������
		int oldshopnum = addstock.getShopnum();
		// �˻������Ʒ����
		int newshopnum = oldshopnum - shopnum1;
		// �����˻�����Ʒ������ֵ
		addstock.setShopnum(newshopnum);
		// ������Ʒ������Ϣ
		service.updateStock(addstock);
		
		// ����˻���Ϣ
		repurchaseService.addRepurchase(repurchase);

		// ɾ��������Ϣ
		int out1 = purchaseDao.delePurchase(purchase);

		Map<String, Integer> map = new HashMap<>();
		// �жϽ�����Ϣɾ���Ƿ�ɹ�
		if (out1 > 0) {// ��
			// ����map��ֵΪ1
			map.put("type", 1);
		} else {// ���ɹ�
				// ����map��ֵΪ0
			map.put("type", 0);
		}
		// ��map��ֵת��Ϊjson���ݴ���ǰ��
		response.getWriter().print(new Gson().toJson(map));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
