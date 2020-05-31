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

@WebServlet("/staffShow")
public class StaffShowSerlvet extends HttpServlet {
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
			pageSize = "2";// 默认显示3条数据
		}

		// 创建sercice对象
		StaffService sercice = new StaffServiceImpl();

		// 进行查询 获取员工列表
		List<Staff> showstaffs = sercice.showStaffs();
		// 获取员工列表大小
		int size = showstaffs.size();
		// 分页查询员工信息列表
		List<Staff> staffsBypage = sercice.getStaffByPage(nowPage, pageSize);
		// 总页数
		int allpage = sercice.getAllpage(pageSize);

		// 加入到作用域中
		request.setAttribute("staffsBypage", staffsBypage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发到主页
		request.getRequestDispatcher("jsp/staff.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
