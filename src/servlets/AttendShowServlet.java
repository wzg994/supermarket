package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StaffAttend;
import services.AttendService;
import services.AttendServiceImpl;


@WebServlet("/attendShow")
public class AttendShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传值
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("前端页数为：" + nowPage);
		System.out.println("页数为:" + pageSize);
		// 如果前端没有传值
		if (nowPage == null) {
			nowPage = "1";// 默认第一页
		}
		if (pageSize == null) {
			pageSize = "2";// 默认显示3条数据
		}

		// 创建ProductSercice对象
		AttendService service = new AttendServiceImpl();

		// 进行查询 获取考勤列表
		List<StaffAttend> staffAttends = service.showAttend();
		// 获取考勤信息大小
		int size = staffAttends.size();

		// 分页查询考勤信息
		List<StaffAttend> attendByPage = service.getAttendByPage(nowPage, pageSize);

		// 总页数
		int allpage = service.getAllpage(pageSize);

		// 放到request作用域
		request.setAttribute("attendsBypage", attendByPage);// 分页信息
		request.setAttribute("totalsize", size);// 总条数
		request.setAttribute("allpage", allpage);// 总页数
		request.setAttribute("nowPage", nowPage);// 当前页

		// 请求转发
		request.getRequestDispatcher("/jsp/attend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
