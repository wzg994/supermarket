package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Repurchase;
import services.RepurchaseService;
import services.RepurchaseServiceImpl;

@WebServlet("/operationRepurchase")
public class OperationRepurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ǰ�˻�ȡֵ
		String purid = request.getParameter("repurid");
		// ���ղ�����
		String operation = request.getParameter("operation");

		// ���Ǹ���ʱ �޸�
		RepurchaseService repurchaseService = new RepurchaseServiceImpl();

		// �ж��˻�id�Ƿ����
		if (purid == null) {// ������
			// �жϲ�������ֵ
			if (operation.equals("4")) {// ������Ϊ4��ִ��ģ����ѯ����
				// ��ȡǰ����Ʒ���Ƶ�ֵ
				String shopname = request.getParameter("shopname");
				// ������Ʒ���ƽ���ģ����ѯ
				List<Repurchase> selectRepurchase = repurchaseService.selectPepurchaseByName(shopname);
				// �ж�ģ����ѯ�����˻���Ϣ��ֵ
				if (selectRepurchase.size() == 0) {// Ϊ0
					// ������ʾ��Ϣ
					request.setAttribute("repurchasemsg", "û�з�����������Ϣ");
				} else {
					// �����ݷŵ�������
					request.setAttribute("repurchase", selectRepurchase);
				}
				// �ض���ҳ��
				request.getRequestDispatcher("jsp/look/lookRepurchase.jsp").forward(request, response);
			}
		} else {
			// ��ѯ�˻���Ϣ ���� �û�id
			Repurchase repurchase = repurchaseService.getRepurchaseById(Integer.parseInt(purid));
			// �ж��˻���Ϣ�Ƿ�Ϊ��
			if (repurchase == null) {// Ϊ��
				System.out.println("��ѯ������");
			} else {
				// ��ȡ�����ǰ��·��
				String url = request.getHeader("Referer");

				// ���ݻ�ȡ�Ĳ����������ж�
				if (operation.equals("1")) {// ������Ϊ1��ɾ���˻���Ϣ
					// ɾ���˻���Ϣ
					repurchaseService.deleRepurcahse(repurchase);
					// �ض���
					response.sendRedirect(url);
				} else if (operation.equals("2")) {// ������Ϊ2��ִ�в�����Ϣ
					// �����ݷŵ�������
					request.setAttribute("repurchase", repurchase);
					// ����ת��
					request.getRequestDispatcher("jsp/update/updateRepurchse.jsp").forward(request, response);
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
