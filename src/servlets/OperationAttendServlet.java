package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.StaffAttend;
import dao.StaffAttendDao;
import dao.StaffAttendDaoImpl;

@WebServlet("/operationAttend")
public class OperationAttendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˽���ֵ
		String staffid = request.getParameter("staffid");
		String operation = request.getParameter("operation");

		//����aattendDao����
		StaffAttendDao attendDao=new StaffAttendDaoImpl();
		//��ȡ��ǰ��url��ַ
		String url = request.getHeader("Referer");
		//����id��ѯ������Ϣ
		StaffAttend staffattend = attendDao.getStaffattendById(Integer.parseInt(staffid));
		
		//�жϲ�ѯ����Ϣ�Ƿ����
		if (staffattend == null) {//������
			System.out.println("��ѯ������");
		}else {//����
			//�жϲ�������ֵ
			if (operation.equals("4")) {//����������4��ִ��ɾ������
				//ɾ��������
				attendDao.deleteStaffattend(staffattend);
				//�ض���ҳ��
				response.sendRedirect(url);
			} else if (operation.equals("2")) {//����������2��ִ�и��²���
				//����ѯ������Ϣ�ŵ�������
				request.setAttribute("attend", staffattend);
				// ����������ת����ָ��ҳ��
				request.getRequestDispatcher("jsp/update/updateAttend.jsp").forward(request, response);
			} else if (operation.equals("5")) {//����������5�� ִ�в�ѯ����
				//���ݿ�����Ϣ��ѯ���ڵ�����Ϣ
				List<StaffAttend> selectStaffattend = attendDao.selectStaffattend(staffattend);
				//�����ݷŵ�������
				request.setAttribute("attend", selectStaffattend);
				//����ת�����ݵ�ָ��ҳ��
				request.getRequestDispatcher("jsp/look/lookAttend.jsp").forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
