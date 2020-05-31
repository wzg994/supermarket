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
		// ����ǰ�˴�ֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("ǰ��ҳ��Ϊ��" + nowPage);
		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "2";// Ĭ����ʾ3������
		}

		// ����ProductSercice����
		AttendService service = new AttendServiceImpl();

		// ���в�ѯ ��ȡ�����б�
		List<StaffAttend> staffAttends = service.showAttend();
		// ��ȡ������Ϣ��С
		int size = staffAttends.size();

		// ��ҳ��ѯ������Ϣ
		List<StaffAttend> attendByPage = service.getAttendByPage(nowPage, pageSize);

		// ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// �ŵ�request������
		request.setAttribute("attendsBypage", attendByPage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ

		// ����ת��
		request.getRequestDispatcher("/jsp/attend.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
