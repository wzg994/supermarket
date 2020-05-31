package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Staff;
import beans.StaffAttend;
import services.AttendService;
import services.AttendServiceImpl;
import services.StaffService;
import services.StaffServiceImpl;

@WebServlet("/addStaff")
public class AddStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
		String idnum = request.getParameter("idnum");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String staffadd = request.getParameter("staffadd");
		String staffedu = request.getParameter("staffedu");
		String staffpassword = request.getParameter("staffpassword");

		// 进行添加员工
		StaffService staffService = new StaffServiceImpl();
		Staff staff = new Staff();

		// 设置员工信息的值
		staff.setStaffid(staffid);
		staff.setStaffname(staffname);
		staff.setIdnum(idnum);
		staff.setSex(sex);
		staff.setTel(tel);
		staff.setStaffadd(staffadd);
		staff.setStaffedu(staffedu);
		staff.setStaffpassword(staffpassword);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date());

		// 创建AttendService对象
		AttendService service = new AttendServiceImpl();
		StaffAttend staffAttend = new StaffAttend();
		staffAttend.setStaffname(staffname);
		try {
			staffAttend.setStafftime(df.parse(format2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 设置员考勤的信息
		staffAttend.setStaffid(Integer.parseInt(staffid));
		// 执行新增考勤信息
		service.addAttend(staffAttend);

		// 新增员工信息
		int out = staffService.addStaff(staff);
		// 获取请求前的路径
		String url = request.getHeader("Referer");
		// 判断新增员工信息是否成功
		if (out != 0) {// 成功
			// 重定向到信息界面
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
