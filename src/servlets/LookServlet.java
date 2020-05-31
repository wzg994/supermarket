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
		// 接收前端的值
		String porid = request.getParameter("proid");

		// 创建productSerive对象
		ProductSerive productSerive = new ProductSeriveImpl();
		// 根据商品id查询商品信息
		Product productById = productSerive.getProductById(Integer.parseInt(porid));

		/*
		 * 获取商品信息生成二维码图片
		 */
		// 获取商品信息并设置值
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String proid1 = productById.getProid();
		String pname = productById.getPname();
		Double price = productById.getPrice();
		int pronum = productById.getPronum();
		Date prodate = productById.getProdate();
		String supname = productById.getSupname();
		String typename = productById.getTypename();
		String format = df.format(prodate);

		// 将商品信息设置为字符串
		String a = "商品ID\n";
		String aa = proid1 + "\n";
		String b = "商品名称\n";
		String bb = pname + "\n";
		String c = "商品价格\n";
		String cc = String.valueOf(price) + "\n";
		String d = "商品数量\n";
		String dd = String.valueOf(pronum) + "\n";
		String e = "商品日期\n";
		String ee = format + "\n";
		String f = "供应商\n";
		String ff = supname + "\n";
		String g = "商品类别\n";
		String gg = typename;

		// 拼接字符串
		String pro = a + aa + b + bb + c + cc + d + dd + e + ee + f + ff + g + gg;

		// 设置图片存储位置
		String uploadDir = request.getServletContext().getRealPath("/" + "\\res\\imgs");
		System.out.println("存储路径" + uploadDir);

		// 设置图片名称
		String qrcodeshow = "shop" + proid1;
		// 设置保存路径
		String qrcode2 = uploadDir + "\\" + qrcodeshow + ".jpg";

		// 生成二维码
		QrcodeUtil.getqrcode(pro, qrcode2);

		// 将数据放到request作用域
		request.setAttribute("qrcode", qrcodeshow);

		// 请求转发
		request.getRequestDispatcher("jsp/lookqrcode.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
