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
		// 前端接收值
		String staffid = request.getParameter("staffid");
		String operation = request.getParameter("operation");

		//创建aattendDao对象
		StaffAttendDao attendDao=new StaffAttendDaoImpl();
		//获取当前的url地址
		String url = request.getHeader("Referer");
		//根据id查询考勤信息
		StaffAttend staffattend = attendDao.getStaffattendById(Integer.parseInt(staffid));
		
		//判断查询的信息是否存在
		if (staffattend == null) {//不存在
			System.out.println("查询不存在");
		}else {//存在
			//判断操作数的值
			if (operation.equals("4")) {//操作数等于4，执行删除操作
				//删除考勤新
				attendDao.deleteStaffattend(staffattend);
				//重定向页面
				response.sendRedirect(url);
			} else if (operation.equals("2")) {//操作数等于2，执行更新操作
				//将查询到的信息放到作用域
				request.setAttribute("attend", staffattend);
				// 将数据请求转发到指定页面
				request.getRequestDispatcher("jsp/update/updateAttend.jsp").forward(request, response);
			} else if (operation.equals("5")) {//操作数等于5， 执行查询操作
				//根据考勤信息查询考勤到的信息
				List<StaffAttend> selectStaffattend = attendDao.selectStaffattend(staffattend);
				//将数据放到作用域
				request.setAttribute("attend", selectStaffattend);
				//请求转发数据到指定页面
				request.getRequestDispatcher("jsp/look/lookAttend.jsp").forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
