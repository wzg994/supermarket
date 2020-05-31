package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Type;
import services.TypeService;
import services.TypeServiceImpl;

@WebServlet("/addType")
public class AddTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����ǰ�˴�������ֵ
		String typeid = request.getParameter("typeid");
		String typename = request.getParameter("typename");

		// ���������Ʒ����
		TypeService typeService = new TypeServiceImpl();
		Type type = new Type();
		// ��������Ʒ���͵�ֵ
		type.setTypeid(Integer.parseInt(typeid));
		type.setTypename(typename);
		// ִ��������Ʒ����
		int out = typeService.addtYpe(type);
		// ��ȡ�����ǰ��·��
		String url = request.getHeader("Referer");
		// �ж�������Ӧ���Ƿ�ɹ�
		if (out != 0) {// �ɹ�
			// �ض�����Ϣ����
			response.sendRedirect(url);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
