package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Staff;
import dao.StaffDao;
import dao.StaffDaoImpl;

@WebServlet("/StaffInfoServlet")
public class StaffInfoServlet extends HttpServlet {
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

		// ����staffDao����
		StaffDao staffDao = new StaffDaoImpl();
		// ����Ա��id��ѯԱ����Ϣ
		Staff staff = staffDao.getStaffById(staffid);
		// ����Ա����Ϣ��ֵ
		staff.setStaffid(staffid);
		staff.setStaffname(staffname);
		staff.setIdnum(idnum);
		staff.setSex(sex);
		staff.setTel(tel);
		staff.setStaffadd(staffadd);
		staff.setStaffedu(staffedu);
		staff.setStaffpassword(staffpassword);

		// ����Ա����Ϣ
		int out = staffDao.updateStaff(staff);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
