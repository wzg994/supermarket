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

@WebServlet("/staffRegiter")
public class StaffRegiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端传过来的值
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
//		String idnum=request.getParameter("idnum");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String staffadd = request.getParameter("staffadd");
		String staffedu = request.getParameter("staffedu");
		String staffpassword = request.getParameter("staffpassword");

		// 格式化时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date());

		// 创建service对象
		AttendService service = new AttendServiceImpl();
		StaffAttend staffAttend = new StaffAttend();
		// 设置考勤信息的值
		staffAttend.setStaffname(staffname);
		try {
			staffAttend.setStafftime(df.parse(format2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		staffAttend.setStaffid(Integer.parseInt(staffid));
		System.out.println("考勤新" + staffAttend);
		// 添加考勤信息
		service.addAttend(staffAttend);

		// 进行注册用户
		StaffService staffService = new StaffServiceImpl();
		Staff staff = new Staff();
		
		// 设置注册的员工信息
		staff.setStaffid(staffid);
		staff.setStaffname(staffname);
		staff.setStaffpassword(staffpassword);
//		staff.setIdnum(idnum);
		staff.setSex(sex);
		staff.setTel(tel);
		staff.setStaffedu(staffedu);
		staff.setStaffadd(staffadd);
		// 注册员工信息
		int out = staffService.regstaff(staff);

		// 判断
		if (out != 0) {
			// 重定向到登入界面
			response.sendRedirect(request.getContextPath() + "/jsp/stafflogin.jsp");
		} else {// 用户已经存在
				// 设置提示信息
			request.setAttribute("message", "员工名称已经存在,请重新输入!");
			// 请求转发
			request.getRequestDispatcher("jsp/staffregister.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
