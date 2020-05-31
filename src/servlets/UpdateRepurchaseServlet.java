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
		// ����ǰ�˵�ֵ
		String purid = request.getParameter("purid");
		String shopid = request.getParameter("shopid");
		String shopname = request.getParameter("shopname");
		String shopprice = request.getParameter("shopprice");
		String shopnum = request.getParameter("shopnum");
		String purdate = request.getParameter("purdate");
		String reson = request.getParameter("reson");
		String mark = request.getParameter("mark");

		// �����޸��˻���Ϣ
		// ����repurchaseDao����
		RepurchaseDao repurchaseDao = new RepurchaseDaoImpl();
		// �����˻�id��ѯ�˻���Ϣ
		Repurchase repurchaseById = repurchaseDao.getRepurchaseById(Integer.parseInt(purid));

		// ��ʽ��ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		// �����޸ĵ�ֵ
		repurchaseById.setPurid(Integer.parseInt(purid));
		repurchaseById.setShopid(Integer.parseInt(shopid));
		repurchaseById.setShopname(shopname);
		repurchaseById.setShopnum(Integer.parseInt(shopnum));
		try {
			repurchaseById.setPurdate(df.parse(purdate));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		repurchaseById.setShopprice(Double.parseDouble(shopprice));
		repurchaseById.setReson(reson);
		repurchaseById.setMark(mark);

		// �����˻���Ϣ
		int out = repurchaseDao.updateRepurchase(repurchaseById);

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
