package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/typeShow")
public class TypeShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ǰ�˻�ȡֵ
		String nowPage = request.getParameter("nowpage");
		String pageSize = request.getParameter("pageSize");
		System.out.println("ҳ����С��" + pageSize);
		System.out.println("ҳ��Ϊ:" + pageSize);
		// ���ǰ��û�д�ֵ
		if (nowPage == null) {
			nowPage = "1";// Ĭ�ϵ�һҳ
		}
		if (pageSize == null) {
			pageSize = "4";// Ĭ����ʾ3������
		}

		// ����service����
		TypeService service = new TypeServiceImpl();
		// ��ѯ�����б�
		List<Type> types = service.showType();
		// ��ȡ�������б��С
		int size = types.size();
		// ��ҳ��ѯ�����б�
		List<Type> typebypage = service.getTypeByPage(nowPage, pageSize);
		// ��ȡ��һҳ��
		int allpage = service.getAllpage(pageSize);

		// ���뵽��������
		request.setAttribute("typesBypage", typebypage);// ��ҳ��ѯ
		request.setAttribute("totalsize", size);// ������
		request.setAttribute("allpage", allpage);// ��ҳ��
		request.setAttribute("nowPage", nowPage);// ��ǰҳ
		// ����ת��
		request.getRequestDispatcher("jsp/type.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
