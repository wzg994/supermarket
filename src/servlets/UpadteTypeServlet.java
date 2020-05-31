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


import beans.Type;
import dao.TypeDao;
import dao.TypeDaoImpl;

@WebServlet("/upadteType")
public class UpadteTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//����ǰ�˵�ֵ
		String typeid = request.getParameter("typeid");
		String typename = request.getParameter("typename");

		// �����޸�������Ϣ
		//����typeDao����
		TypeDao typeDao =new TypeDaoImpl();
		//��������id��ѯ������Ϣ
		Type typeById = typeDao.getTypeById(Integer.parseInt(typeid));
		
		//����Ҫ���µ����͵�ֵ
		typeById.setTypeid(Integer.parseInt(typeid));
		typeById.setTypename(typename);

		//����������Ϣ
		int out=typeDao.updateType(typeById);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// ��map��ֵת��Ϊjson���ݴ���ǰ��
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
