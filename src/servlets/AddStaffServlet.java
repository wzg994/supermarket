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
		// ����ǰ�˴�������ֵ
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
		String idnum = request.getParameter("idnum");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String staffadd = request.getParameter("staffadd");
		String staffedu = request.getParameter("staffedu");
		String staffpassword = request.getParameter("staffpassword");

		// �������Ա��
		StaffService staffService = new StaffServiceImpl();
		Staff staff = new Staff();

		// ����Ա����Ϣ��ֵ
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

		// ����AttendService����
		AttendService service = new AttendServiceImpl();
		StaffAttend staffAttend = new StaffAttend();
		staffAttend.setStaffname(staffname);
		try {
			staffAttend.setStafftime(df.parse(format2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// ����Ա���ڵ���Ϣ
		staffAttend.setStaffid(Integer.parseInt(staffid));
		// ִ������������Ϣ
		service.addAttend(staffAttend);

		// ����Ա����Ϣ
		int out = staffService.addStaff(staff);
		// ��ȡ����ǰ��·��
		String url = request.getHeader("Referer");
		// �ж�����Ա����Ϣ�Ƿ�ɹ�
		if (out != 0) {// �ɹ�
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
