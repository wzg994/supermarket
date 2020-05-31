package servlets;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import services.ProductSerive;
import services.ProductSeriveImpl;
import util.QrcodeUtil;

@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˵�ֵ
		String porid = request.getParameter("proid");

		// ����productSerive����
		ProductSerive productSerive = new ProductSeriveImpl();
		// ������Ʒid��ѯ��Ʒ��Ϣ
		Product productById = productSerive.getProductById(Integer.parseInt(porid));

		/*
		 * ��ȡ��Ʒ��Ϣ���ɶ�ά��ͼƬ
		 */
		// ��ȡ��Ʒ��Ϣ������ֵ
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String proid1 = productById.getProid();
		String pname = productById.getPname();
		Double price = productById.getPrice();
		int pronum = productById.getPronum();
		Date prodate = productById.getProdate();
		String supname = productById.getSupname();
		String typename = productById.getTypename();
		String format = df.format(prodate);

		// ����Ʒ��Ϣ����Ϊ�ַ���
		String a = "��ƷID\n";
		String aa = proid1 + "\n";
		String b = "��Ʒ����\n";
		String bb = pname + "\n";
		String c = "��Ʒ�۸�\n";
		String cc = String.valueOf(price) + "\n";
		String d = "��Ʒ����\n";
		String dd = String.valueOf(pronum) + "\n";
		String e = "��Ʒ����\n";
		String ee = format + "\n";
		String f = "��Ӧ��\n";
		String ff = supname + "\n";
		String g = "��Ʒ���\n";
		String gg = typename;

		// ƴ���ַ���
		String pro = a + aa + b + bb + c + cc + d + dd + e + ee + f + ff + g + gg;

		// ����ͼƬ�洢λ��
		String uploadDir = request.getServletContext().getRealPath("/" + "\\res\\imgs");
		System.out.println("�洢·��" + uploadDir);

		// ����ͼƬ����
		String qrcodeshow = "shop" + proid1;
		// ���ñ���·��
		String qrcode2 = uploadDir + "\\" + qrcodeshow + ".jpg";

		// ���ɶ�ά��
		QrcodeUtil.getqrcode(pro, qrcode2);

		// �����ݷŵ�request������
		request.setAttribute("qrcode", qrcodeshow);

		// ����ת��
		request.getRequestDispatcher("jsp/lookqrcode.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
