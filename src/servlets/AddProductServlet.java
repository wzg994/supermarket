package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import services.ProductSerive;
import services.ProductSeriveImpl;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proid = request.getParameter("proid");
		String proname = request.getParameter("proname");
		String proprice = request.getParameter("proprice");
		String pronum = request.getParameter("pronum");
		String prodate = request.getParameter("prodate");
		String supname = request.getParameter("supname");
		String typename	=request.getParameter("typename");

		// 进行新增商品
		ProductSerive productSerive=new ProductSeriveImpl();
		Product product=new Product();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		//设置商品的值
		product.setProid(proid);
		product.setPname(proname);
		product.setPrice(Double.parseDouble(proprice));
		product.setPronum(Integer.parseInt(pronum));
		try {
			product.setProdate(df.parse(prodate));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		product.setSupname(supname);
		product.setTypename(typename);
		
		//新增商品
		int out = productSerive.addProduct(product);
		// 获取请求的前的路径
		String url = request.getHeader("Referer");

		//判断新增商品是否成功
		if (out != 0) {
			// 重定向到信息界面
			response.sendRedirect(url);
			}
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
