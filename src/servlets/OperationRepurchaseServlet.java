package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Repurchase;
import services.RepurchaseService;
import services.RepurchaseServiceImpl;

@WebServlet("/operationRepurchase")
public class OperationRepurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 从前端获取值
		String purid = request.getParameter("repurid");
		// 接收操作数
		String operation = request.getParameter("operation");

		// 这是更新时 修改
		RepurchaseService repurchaseService = new RepurchaseServiceImpl();

		// 判断退货id是否存在
		if (purid == null) {// 不存在
			// 判断操作数的值
			if (operation.equals("4")) {// 操作数为4，执行模糊查询操作
				// 获取前端商品名称的值
				String shopname = request.getParameter("shopname");
				// 根据商品名称进行模糊查询
				List<Repurchase> selectRepurchase = repurchaseService.selectPepurchaseByName(shopname);
				// 判断模糊查询到的退货信息的值
				if (selectRepurchase.size() == 0) {// 为0
					// 设置提示信息
					request.setAttribute("repurchasemsg", "没有符合条件的信息");
				} else {
					// 将数据放到作用域
					request.setAttribute("repurchase", selectRepurchase);
				}
				// 重定向页面
				request.getRequestDispatcher("jsp/look/lookRepurchase.jsp").forward(request, response);
			}
		} else {
			// 查询退货信息 根据 用户id
			Repurchase repurchase = repurchaseService.getRepurchaseById(Integer.parseInt(purid));
			// 判断退货信息是否为空
			if (repurchase == null) {// 为空
				System.out.println("查询不存在");
			} else {
				// 获取请求的前的路径
				String url = request.getHeader("Referer");

				// 根据获取的操作数进行判断
				if (operation.equals("1")) {// 操作数为1，删除退货信息
					// 删除退货信息
					repurchaseService.deleRepurcahse(repurchase);
					// 重定向
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// 操作数为2，执行操作信息
					// 将数据放到作用域
					request.setAttribute("repurchase", repurchase);
					// 请求转发
					request.getRequestDispatcher("jsp/update/updateRepurchse.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
