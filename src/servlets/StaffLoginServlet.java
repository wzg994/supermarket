package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Staff;
import beans.StaffAttend;
import beans.Stock;
import services.AttendService;
import services.AttendServiceImpl;
import services.StaffService;
import services.StaffServiceImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/staffLogin")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String staffname = request.getParameter("username");
		String staffpassword = request.getParameter("password");

		// 进行查询 调用业务逻辑层
		StaffService staffServices = new StaffServiceImpl();
		// 员工登录
		Staff staff = staffServices.logstaff(staffname, staffpassword);

		// 创建AttendService对象
		AttendService service = new AttendServiceImpl();
		// 根据员工名称查询考勤信息
		StaffAttend attendByName = service.getAttendByName(staffname);

		// 判断考勤信息是否存在
		if (attendByName == null) {// 不存在
			System.out.println("没有用户");
		} else {// 存在
			// 创建stockService对象
			StockService stockService = new StockServiceImpl();
			// 查询库存信息列表
			List<Stock> showStocks = stockService.showStocks();
			// 获取库存数量不足的库存信息
			List<Stock> stockNum = stockService.getStockNum(showStocks);
			// 遍历库存不足的信息
			for (Stock stock : stockNum) {
				// 判断库存数量
				if (stock.getShopnum() <= 100) {// 小于等于100
					// 设置商品库存预警信息
					request.getSession().setAttribute("msg", "警告：有商品库存不足，请及时添加！");
				} else {
					System.out.println("没有商品库存不足");

				}
			}

			// 判断账户是否存在
			if (!staffServices.existName(staffname)) {// 员工不存在时
				// 设置错误信息
				request.setAttribute("staffnameErr", "员工不存在");
				// 请求转发
				request.getRequestDispatcher("/jsp/stafflogin.jsp").forward(request, response);
				return;
			}
			// 判断员工是否为空
			if (staff == null) {// staff为空时
				request.setAttribute("staffpasswordErr", "密码错误");
				// 请求转发
				request.getRequestDispatcher("jsp/stafflogin.jsp").forward(request, response);
				return;
			}
			System.out.println("新建考勤信息" + attendByName);
			// 获取考勤次数
			int attendtime = attendByName.getAttendtime();
			// 考勤次数增加
			int updatetime = attendtime + 1;
			// 设置新的考勤信息
			attendByName.setAttendtime(updatetime);
			// 更新考勤信息
			service.updateAttend(attendByName);

			// 把staff对象放到seesion作用域中
			request.getSession().setAttribute("staff", staff);
			// 重定向
			response.sendRedirect(request.getContextPath() + "/jsp/menu.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
