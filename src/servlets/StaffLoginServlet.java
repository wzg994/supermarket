package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Staff;
import beans.StaffAttend;
import beans.Stock;
import services.AttendService;
import services.AttendServiceImpl;
import services.StaffService;
import services.StaffServiceImpl;
import services.StockService;
import services.StockServiceImpl;

@WebServlet("/staffLogin")
public class StaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String staffname = request.getParameter("username");
		String staffpassword = request.getParameter("password");

		// ���в�ѯ ����ҵ���߼���
		StaffService staffServices = new StaffServiceImpl();
		// Ա����¼
		Staff staff = staffServices.logstaff(staffname, staffpassword);

		// ����AttendService����
		AttendService service = new AttendServiceImpl();
		// ����Ա�����Ʋ�ѯ������Ϣ
		StaffAttend attendByName = service.getAttendByName(staffname);

		// �жϿ�����Ϣ�Ƿ����
		if (attendByName == null) {// ������
			System.out.println("û���û�");
		} else {// ����
			// ����stockService����
			StockService stockService = new StockServiceImpl();
			// ��ѯ�����Ϣ�б�
			List<Stock> showStocks = stockService.showStocks();
			// ��ȡ�����������Ŀ����Ϣ
			List<Stock> stockNum = stockService.getStockNum(showStocks);
			// ������治�����Ϣ
			for (Stock stock : stockNum) {
				// �жϿ������
				if (stock.getShopnum() <= 100) {// С�ڵ���100
					// ������Ʒ���Ԥ����Ϣ
					request.getSession().setAttribute("msg", "���棺����Ʒ��治�㣬�뼰ʱ��ӣ�");
				} else {
					System.out.println("û����Ʒ��治��");

				}
			}

			// �ж��˻��Ƿ����
			if (!staffServices.existName(staffname)) {// Ա��������ʱ
				// ���ô�����Ϣ
				request.setAttribute("staffnameErr", "Ա��������");
				// ����ת��
				request.getRequestDispatcher("/jsp/stafflogin.jsp").forward(request, response);
				return;
			}
			// �ж�Ա���Ƿ�Ϊ��
			if (staff == null) {// staffΪ��ʱ
				request.setAttribute("staffpasswordErr", "�������");
				// ����ת��
				request.getRequestDispatcher("jsp/stafflogin.jsp").forward(request, response);
				return;
			}
			System.out.println("�½�������Ϣ" + attendByName);
			// ��ȡ���ڴ���
			int attendtime = attendByName.getAttendtime();
			// ���ڴ�������
			int updatetime = attendtime + 1;
			// �����µĿ�����Ϣ
			attendByName.setAttendtime(updatetime);
			// ���¿�����Ϣ
			service.updateAttend(attendByName);

			// ��staff����ŵ�seesion��������
			request.getSession().setAttribute("staff", staff);
			// �ض���
			response.sendRedirect(request.getContextPath() + "/jsp/menu.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
