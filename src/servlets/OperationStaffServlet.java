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

@WebServlet("/operationStaff")
public class OperationStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String staffid = request.getParameter("staffid");
		String operation = request.getParameter("operation");

		// ����staffService����
		StaffService staffService = new StaffServiceImpl();
		// ��ȡ��ǰ�����url��ַ
		String url = request.getHeader("Referer");
		// �ж�Ա��id�Ƿ�Ϊ������
		if (staffid == null) {// ������
			// �жϲ�������ֵ
			if (operation.equals("5")) {// ������Ϊ5��ģ����ѯԱ����Ϣ
				// ��ȡԱ������
				String staffname = request.getParameter("staffname");
				// ����Ա������ģ����ѯԱ����Ϣ
				List<Staff> selectStaffByName = staffService.selectStaffByName(staffname);
				// �ж�ģ����ѯ����Ϣ��С
				if (selectStaffByName.size() == 0) {// Ϊ0
					// ������ʾ��Ϣ
					request.setAttribute("staffmsg", "û�з�����������Ϣ");
				} else {
					// �����ݷŵ�������
					request.setAttribute("staff", selectStaffByName);
				}
				// ����ת��
				request.getRequestDispatcher("jsp/look/lookStaff.jsp").forward(request, response);
			}
		} else {
			// ��ѯԱ����Ϣ
			Staff staff = staffService.getStaffById(staffid);
			// �ж�Ա����Ϣ�Ƿ����
			if (staff == null) {// ������
				System.out.println("��ѯ������");
			} else {
				// �жϲ�������ֵ
				if (operation.equals("4")) {// ������Ϊ4��ִ��ɾ������
					// ɾ��Ա����Ϣ
					staffService.deleStaff(staff);
					// �ض���
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// ������Ϊ2��ִ�и��²���
					// �����ݷŵ�������
					request.setAttribute("staff", staff);
					// ����ת��
					request.getRequestDispatcher("jsp/update/updateStaff.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
