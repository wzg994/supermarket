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
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");

		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "2";// Ĭ����ʾ3������
		}

		// ����sercice����
		StaffService sercice = new StaffServiceImpl();

		// ���в�ѯ ��ȡԱ���б�
		List<Staff> showstaffs = sercice.showStaffs();
		// ��ȡԱ���б��С
		int size = showstaffs.size();
		// ��ҳ��ѯԱ����Ϣ�б�
		List<Staff> staffsBypage = sercice.getStaffByPage(nowPage, pageSize);
		// ��ҳ��
		int allpage = sercice.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("staffsBypage", staffsBypage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת������ҳ
		request.getRequestDispatcher("jsp/staff.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
