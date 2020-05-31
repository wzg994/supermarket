package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Staff;
import services.StaffService;
import services.StaffServiceImpl;

@WebServlet("/operationStaff")
public class OperationStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 前端接收值
		String staffid = request.getParameter("staffid");
		String operation = request.getParameter("operation");

		// 创建staffService对象
		StaffService staffService = new StaffServiceImpl();
		// 获取当前请求的url地址
		String url = request.getHeader("Referer");
		// 判断员工id是否为不存在
		if (staffid == null) {// 不存在
			// 判断操作数的值
			if (operation.equals("5")) {// 操作数为5，模糊查询员工信息
				// 获取员工名称
				String staffname = request.getParameter("staffname");
				// 根据员工名称模糊查询员工信息
				List<Staff> selectStaffByName = staffService.selectStaffByName(staffname);
				// 判断模糊查询的信息大小
				if (selectStaffByName.size() == 0) {// 为0
					// 设置提示信息
					request.setAttribute("staffmsg", "没有符合条件的信息");
				} else {
					// 将数据放到作用域
					request.setAttribute("staff", selectStaffByName);
				}
				// 请求转发
				request.getRequestDispatcher("jsp/look/lookStaff.jsp").forward(request, response);
			}
		} else {
			// 查询员工信息
			Staff staff = staffService.getStaffById(staffid);
			// 判断员工信息是否存在
			if (staff == null) {// 不存在
				System.out.println("查询不存在");
			} else {
				// 判断操作数的值
				if (operation.equals("4")) {// 操作数为4，执行删除操作
					// 删除员工信息
					staffService.deleStaff(staff);
					// 重定向
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// 操作数为2，执行更新操作
					// 将数据放到作用域
					request.setAttribute("staff", staff);
					// 请求转发
					request.getRequestDispatcher("jsp/update/updateStaff.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
