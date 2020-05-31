package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import beans.Type;
import services.ProductSerive;
import services.ProductSeriveImpl;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/productshow")
public class ProductshowSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "5";// 默认显示3条数据
		}

		// 创建ProductSercice对象
		ProductSerive sercice = new ProductSeriveImpl();

		// 创建typeService对象
		TypeService typeService = new TypeServiceImpl();
		// 查询所有商品类型
		List<Type> showType = typeService.showType();

		// 进行查询 获取商品列表
		List<Product> showproducts = sercice.showProduct();
		// 获取信息总大小
		int size = showproducts.size();

		// 分页查询商品信息
		List<Product> shopsBypage = sercice.getProductByPage(nowPage, pageSize);
		// 获取总页数
		int allpage = sercice.getAllpage(pageSize);

		// 放到request作用域
		request.setAttribute("protype", showType);// 商品类别信息
		request.setAttribute("shopsBypage", shopsBypage);// 分页信息
		request.setAttribute("totalsize", size);// 总页数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发到主页
		request.getRequestDispatcher("/jsp/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
