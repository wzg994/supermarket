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
		// ��ǰ�˻�ȡֵ
		String purid = request.getParameter("purid");
		// ���ղ�����
		String operation = request.getParameter("operation");

		// ��������
		PurchaseService purchaseService = new PurchaseServiceImpl();

		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");
		// �жϽ���id�Ƿ����
		if (purid == null) {// ������
			// �жϲ�������ֵ
			if (operation.equals("3")) {// ������Ϊ3��ִ��ģ�������
				// ��ȡǰ����Ʒ����
				String shopname = request.getParameter("shopname");
				// ������Ʒ����ģ����ѯ������Ϣ
				List<Purchase> selectPurchaseByName = purchaseService.selectPurchaseByName(shopname);
				// �жϲ�ѯ���Ľ�����Ϣ�Ĵ�С
				if (selectPurchaseByName.size() == 0) {// Ϊ0,
					// ������ʾ��Ϣ
					request.setAttribute("purchasemsg", "û�з�����������Ϣ");
				} else {// ��Ϊ0
						// �����ݷŵ�������
					request.setAttribute("purchases", selectPurchaseByName);
				}
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookpurchase.jsp").forward(request, response);
			}
		} else {// ����
				// ��ѯ��Ʒ��Ϣ ���� ��Ʒid
			Purchase purchase = purchaseService.getPurchaseId(Integer.parseInt(purid));
			// �жϽ�����Ϣ�Ƿ����
			if (purchase == null) {// ������
				System.out.println("��ѯ������");
			} else {// ����
					// �жϲ�������ֵ
				if (operation.equals("1")) {// ������Ϊ1��ִ�н�����Ϣ��ɾ���������˻���Ϣ����Ӳ�����������Ʒ���
					// �����˵���Ϣ����
					RepurchaseService repurchaseService = new RepurchaseServiceImpl();
					Repurchase repurchase = new Repurchase();
					// �����˵���Ϣ��ֵ
					repurchase.setPurid(purchase.getPurid());
					repurchase.setShopid(Integer.parseInt(purchase.getShopid()));
					repurchase.setShopname(purchase.getShopname());
					repurchase.setShopprice(purchase.getShopprice());
					repurchase.setShopnum(purchase.getShopnum());
					repurchase.setPurdate(purchase.getPurdate());
					repurchase.setMark(purchase.getSupname());

					// ��Ʒ�����Ϣ�ĸ���
					StockService service = new StockServiceImpl();
					// ������Ʒ���Ʋ�ѯ��Ʒ���
					Stock addstock = service.getSaleByName(purchase.getShopname());

					// �ж���Ʒ��Ϣ�Ƿ����
					if (addstock == null) {// ������
						Stock stock = new Stock();
						// ���ÿ����Ϣ��ֵ
						stock.setShopname(purchase.getShopname());
						stock.setShopnum(purchase.getShopnum());
						// ��ӿ����Ϣ
						service.addstock(stock);
					}

					// ��ȡ������Ϣ����Ʒ����
					int shopnum1 = purchase.getShopnum();
					// ��ȡ��Ʒ�������
					int oldshopnum = addstock.getShopnum();
					// ��ȡ�˻������Ʒ����
					int newshopnum = oldshopnum - shopnum1;
					// ������Ʒ�������
					addstock.setShopnum(newshopnum);
					// ������Ʒ�������
					service.updateStock(addstock);
					// ����˻���Ϣ
					repurchaseService.addRepurchase(repurchase);
					// ɾ��������Ϣ
					purchaseService.delePurchase(purchase);
					// �ض���
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���
					// �����ݷŵ�������
					request.setAttribute("purchase", purchase);
					// ����ת��
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
