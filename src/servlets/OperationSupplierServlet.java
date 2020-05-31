package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Supplier;
import dao.SupplierDao;
import dao.SupplierDaoImpl;

@WebServlet("/operationSupplier")
public class OperationSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 从前端获取值
		String supplierid = request.getParameter("supplierId");
		// 接收操作数
		String operation = request.getParameter("operation");

		// 创建supplierDao对象
		SupplierDao supplierDao = new SupplierDaoImpl();

		// 获取请求的前的路径
		String url = request.getHeader("Referer");
		// 判断供应商id是否存在
		if (supplierid == null) {// 不存在
			// 获取供应商名称
			String supname = request.getParameter("supname");
			// 判断操作数的值
			if (operation.equals("5")) {// 操作数为5，执行模糊查询
				// 根据供应商名称模糊查询供应商信息列表
				List<Supplier> selectSupplier = supplierDao.getSupplier(supname);
				// 判断供应商信息列表的大小
				if (selectSupplier.size() == 0) {// 为0
					// 设置提示信息放到前端
					request.setAttribute("suppliermsg", "查询不存在");
				} else {
					// 将数据放到作用域
					request.setAttribute("supplier", selectSupplier);
				}
				// 请求转发
				request.getRequestDispatcher("jsp/look/looksupplier.jsp").forward(request, response);
			}
		} else {
			// 查询根据供应商信息 id
			Supplier supplier = supplierDao.getSupById(Integer.parseInt(supplierid));
			// 判断供应商信息是否存在
			if (supplier == null) {// 不存在
				System.out.println("没有查询步骤");
			} else {// 存在
					// 判断操作数的值
				if (operation.equals("4")) {// 操作数为4,删除
					// 删除供应商
					supplierDao.deleSupplier(supplier);
					// 重定向
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// 操作数为2, 更新
					// 将要更新的信息放到作用域
					request.setAttribute("supplier", supplier);
					// 请求转发
					request.getRequestDispatcher("jsp/update/updateSupplier.jsp").forward(request, response);
				} else if (operation.equals("3")) {// 操作数为3,新增
					System.out.println("新增信息111");
					System.out.println("更新完的值为" + supplier);

					request.setAttribute("supplier", supplier);
					response.sendRedirect(url);
				}
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
