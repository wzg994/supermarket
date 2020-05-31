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
		//接收前端的值
		String typeid = request.getParameter("typeid");
		String typename = request.getParameter("typename");

		// 进行修改类型信息
		//创建typeDao对象
		TypeDao typeDao =new TypeDaoImpl();
		//根据类型id查询类型信息
		Type typeById = typeDao.getTypeById(Integer.parseInt(typeid));
		
		//设置要更新的类型的值
		typeById.setTypeid(Integer.parseInt(typeid));
		typeById.setTypename(typename);

		//更新类型信息
		int out=typeDao.updateType(typeById);

		Map<String, Integer> map = new HashMap<>();
		if (out > 0) {
			map.put("type", 1);
		} else {
			map.put("type", 0);
		}
		// 把map的值转化为json数据传给前端
		response.getWriter().print(new Gson().toJson(map));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
