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

@WebServlet("/repurchaseShow")
public class RepurchaseShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ǰ�˻�ȡֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "5";// Ĭ����ʾ3������
		}

		// ����service����
		RepurchaseService service = new RepurchaseServiceImpl();
		// ��ѯ�˻���Ϣ�б�
		List<Repurchase> showRepurchases = service.showRepurchase();
		// ��ȡ�˻���Ϣ���Ĵ�С
		int size = showRepurchases.size();

		// �˻���ҳ
		List<Repurchase> repurchasesByPage = service.getRepurchaseByPage(nowPage, pageSize);
		// ��ȡ��ҳ��
		int allpage = service.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("repurchasesByPage", repurchasesByPage);// ��ҳ��Ϣ
		request.setAttribute("totalsize", size);// ��ҳ��
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ
		// ����ת��
		request.getRequestDispatcher("jsp/repurchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
