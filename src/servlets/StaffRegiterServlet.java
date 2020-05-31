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
		// ����ǰ�˴�������ֵ
		String staffid = request.getParameter("staffid");
		String staffname = request.getParameter("staffname");
//		String idnum=request.getParameter("idnum");
		String sex = request.getParameter("sex");
		String tel = request.getParameter("tel");
		String staffadd = request.getParameter("staffadd");
		String staffedu = request.getParameter("staffedu");
		String staffpassword = request.getParameter("staffpassword");

		// ��ʽ��ʱ��
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date());

		// ����service����
		AttendService service = new AttendServiceImpl();
		StaffAttend staffAttend = new StaffAttend();
		// ���ÿ�����Ϣ��ֵ
		staffAttend.setStaffname(staffname);
		try {
			staffAttend.setStafftime(df.parse(format2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		staffAttend.setStaffid(Integer.parseInt(staffid));
		System.out.println("������" + staffAttend);
		// ��ӿ�����Ϣ
		service.addAttend(staffAttend);

		// ����ע���û�
		StaffService staffService = new StaffServiceImpl();
		Staff staff = new Staff();
		
		// ����ע���Ա����Ϣ
		staff.setStaffid(staffid);
		staff.setStaffname(staffname);
		staff.setStaffpassword(staffpassword);
//		staff.setIdnum(idnum);
		staff.setSex(sex);
		staff.setTel(tel);
		staff.setStaffedu(staffedu);
		staff.setStaffadd(staffadd);
		// ע��Ա����Ϣ
		int out = staffService.regstaff(staff);

		// �ж�
		if (out != 0) {
			// �ض��򵽵������
			response.sendRedirect(request.getContextPath() + "/jsp/stafflogin.jsp");
		} else {// �û��Ѿ�����
				// ������ʾ��Ϣ
			request.setAttribute("message", "Ա�������Ѿ�����,����������!");
			// ����ת��
			request.getRequestDispatcher("jsp/staffregister.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
