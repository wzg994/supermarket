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
		// ����ǰ�˵�ֵ
		String purid = request.getParameter("purid");
		String shopid = request.getParameter("shopid");
		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
		String shopnum = request.getParameter("shopnum");
		String purdate = request.getParameter("purdate");
		String supname = request.getParameter("supname");

		// �����޸Ľ�����Ϣ
		// ����purchaseDao����
		PurchaseDao purchaseDao = new PurchaseDaoImpl();
		// ���ݽ���id��ѯ������Ϣ
		Purchase purchaseById = purchaseDao.getPurchaseById(Integer.parseInt(purid));
		// ��ʽ��ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// �����޸ĵ�ֵ
		purchaseById.setShopid(shopid);
		purchaseById.setShopname(shopname);
		purchaseById.setShopprice(Double.valueOf(shopprice));
		try {
			purchaseById.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		purchaseById.setSupname(supname);

		// ������Ʒ�����Ϣ
		// ����service����
		StockService service = new StockServiceImpl();
		// ������Ʒ���Ʋ�ѯ��Ʒ��Ϣ
		Stock addstock = service.getSaleByName(purchaseById.getShopname());
		// ��ȡ������Ϣ����
		int shopnum1 = purchaseById.getShopnum();
		// �ж��Ƿ���ڿ����Ϣ
		if (addstock == null) {// ������
			Stock stock = new Stock();
			stock.setShopname(purchaseById.getShopname());
			stock.setShopnum(purchaseById.getShopnum());
			service.addstock(stock);
			System.out.println("��ӳɹ�");
		} else {// ����
			// ��ȡ�������
			int oldshopnum = addstock.getShopnum();
			// ��ȡ���µ���Ϣ
			int updatenum = Integer.parseInt(shopnum);
			// ��ȡ���µĿ������
			int newnum = updatenum - shopnum1;
			// ��ȡ���º�Ŀ������
			int newshopnum = oldshopnum + newnum;
			// ���ÿ������
			addstock.setShopnum(newshopnum);
			// ���¿����Ϣ
			service.updateStock(addstock);
		}

		purchaseById.setShopnum(Integer.parseInt(shopnum));

		// ����stockService����
		StockService stockService = new StockServiceImpl();
		// ��ȡ�����Ϣ�б�
		List<Stock> showStocks = stockService.showStocks();
		// ��ȡ��Ʒ�����Ϣ�������Ϣ
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		// �жϿ����Ϣ�б��Ƿ�Ϊ��
		if (stockNum.isEmpty()) {// Ϊ��
			// ����Ԥ����ϢΪ��(�����Ƴ�Ԥ����Ϣ)
			request.getSession().setAttribute("msg", "");
		}

		// ���½�����Ϣ
		int out = purchaseDao.updatePurchase(purchaseById);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
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
