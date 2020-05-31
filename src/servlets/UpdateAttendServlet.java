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
		// ����ǰ�˵�ֵ
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
		String stafftime = request.getParameter("stafftime");
		String attendtime = request.getParameter("attendtime");
		String mark = request.getParameter("mark");

		// �����޸Ŀ�����Ϣ
		// ����service����
		AttendService service = new AttendServiceImpl();
		// ���ݿ���id��ѯ������Ϣ
		StaffAttend ateend = service.getAteendById(Integer.parseInt(staffid));

		// ��ʽ��ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����Ҫ�޸ĵĿ�����Ϣ
		ateend.setStaffid(Integer.parseInt(staffid));
		ateend.setStaffname(staffname);
		try {
			ateend.setStafftime(df.parse(stafftime));
		} catch (ParseException e) {
			System.out.println("û���������ڣ��������ڸ�ʽ����");
		}
		ateend.setAttendtime(Integer.parseInt(attendtime));
		ateend.setMark(mark);

		// ���¿�����Ϣ
		int out = service.updateAttend(ateend);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// ��map��ֵת��Ϊjson���ݴ���ǰ��
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
