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

@WebServlet("/operationProduct")
public class OperationProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String shopid = request.getParameter("proid");
		String operation = request.getParameter("operation");

		// 创建productSerive对象
		ProductSerive productSerive = new ProductSeriveImpl();
		// 获取当前url地址
		String url = request.getHeader("Referer");

		// 判断商品id是否存在
		if (shopid == null) {// 不存在，执行模糊查询操作
			// 判断操作数数值
			if (operation.equals("5")) {// 操作数为5，执行模糊查询
				// 获取前端传过来的商品名称
				String shopname = request.getParameter("shopname");
				// 根据商品名称进行模糊查询商品信息
				List<Product> selectProductByName = productSerive.selectProductByName(shopname);
				/*
				 * 判断是否有符合条件的商品信息
				 */
				// 判断查询的商品信息是否为空
				if (selectProductByName.size() == 0) {// 为空
					// 设置日式信息
					request.setAttribute("productmsg", "没有符合条件的信息");
				} else {// 不为空
					// 将查询的信息放到作用域
					request.setAttribute("products", selectProductByName);
				}
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookproduct.jsp").forward(request, response);
			}
		} else {// 存在商品id
			// 获取商品信息
			Product product = productSerive.getProductById(Integer.parseInt(shopid));
			// 判断商品信息是否存在
			if (product == null) {// 不存在
				System.out.println("查询不存在");
			} else {// 存在
					// 判断操作数的值
				if (operation.equals("4")) {// 操作数为4，执行删除操作
					// 删除商品
					productSerive.deleProduct(product);
					// 重定向
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// 操作数为2，执行更新操作

					// 创建typeService对象
					TypeService typeService = new TypeServiceImpl();
					// 查询所有商品类型
					List<Type> showType = typeService.showType();
					// 放到request作用域
					request.setAttribute("protype", showType);
					request.setAttribute("product", product);
					// 请求转发到指定页面
					request.getRequestDispatcher("jsp/update/updateProduct.jsp").forward(request, response);
				}
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
