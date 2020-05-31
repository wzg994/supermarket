package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.StaffAttend;
import services.AttendService;
import services.AttendServiceImpl;

@WebServlet("/updateAttend")
public class UpdateAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收前端的值
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
		String stafftime = request.getParameter("stafftime");
		String attendtime = request.getParameter("attendtime");
		String mark = request.getParameter("mark");

		// 进行修改考勤信息
		// 创建service对象
		AttendService service = new AttendServiceImpl();
		// 根据考勤id查询考勤信息
		StaffAttend ateend = service.getAteendById(Integer.parseInt(staffid));

		// 格式化时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 设置要修改的考勤信息
		ateend.setStaffid(Integer.parseInt(staffid));
		ateend.setStaffname(staffname);
		try {
			ateend.setStafftime(df.parse(stafftime));
		} catch (ParseException e) {
			System.out.println("没有输入日期，或者日期格式错误");
		}
		ateend.setAttendtime(Integer.parseInt(attendtime));
		ateend.setMark(mark);

		// 更新考勤信息
		int out = service.updateAttend(ateend);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// 把map的值转化为json数据传给前端
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
