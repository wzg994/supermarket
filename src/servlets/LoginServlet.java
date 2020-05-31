package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Stock;
import beans.User;
import services.UserServiceImpl;
import services.StockService;
import services.StockServiceImpl;
import services.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收前端传过来的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//进行查询 调用业务逻辑层
		UserService userServices=new UserServiceImpl();
		//用户登录
		User user = userServices.login(username, password);
		
		
		/*
		 * 查询商品库存是否有不足
		 */
		//创建商品库存对象
		StockService stockService=new StockServiceImpl();
		//查询所有的商品信息
		List<Stock> showStocks = stockService.showStocks();
		
		//获取所有商品的数量
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		System.out.println("库存不足的有"+stockNum);
		//遍历所有商品信息
		for (Stock stock : stockNum) {
			//判断商品数量是否小于等于100
			if(stock.getShopnum()<=100) {//是
				//设置商品库存预警信息
				request.getSession().setAttribute("msg", "警告：有商品库存不足，请及时添加！");
			}else {
				System.out.println("没有商品库存不足");
				//request.getSession().removeAttribute("msg");
			}
		}
		//判断是否存在管理员
		if (!userServices.existName(username)) {//存在
			//设置错误信息
			request.setAttribute("usernameErr", "用户不存在");//存入错误信息
			//请求转发
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
		
		//判断管理员是否为空
		if (user==null) {//user为空时
			
			request.setAttribute("passwordErr", "密码错误");//存入错误信息
			//请求转发
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
//		else {//user为空时 
//			System.out.println("错误用户"+user+"不存在");
//			System.out.println("用户名或者密码错误");
//			request.setAttribute("wordname", username);
//			request.setAttribute("wordpassword", password);
//			request.setAttribute("message","用户名和密码错误");
//			//请求转发
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//		}

		//把user对象放到seesion作用域中
		request.getSession().setAttribute("user", user);
		
		//重定向
		response.sendRedirect(request.getContextPath()+"/jsp/user/adminmenu.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
