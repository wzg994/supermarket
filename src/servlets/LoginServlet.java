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
		//����ǰ�˴�������ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//���в�ѯ ����ҵ���߼���
		UserService userServices=new UserServiceImpl();
		//�û���¼
		User user = userServices.login(username, password);
		
		
		/*
		 * ��ѯ��Ʒ����Ƿ��в���
		 */
		//������Ʒ������
		StockService stockService=new StockServiceImpl();
		//��ѯ���е���Ʒ��Ϣ
		List<Stock> showStocks = stockService.showStocks();
		
		//��ȡ������Ʒ������
		List<Stock> stockNum = stockService.getStockNum(showStocks);
		System.out.println("��治�����"+stockNum);
		//����������Ʒ��Ϣ
		for (Stock stock : stockNum) {
			//�ж���Ʒ�����Ƿ�С�ڵ���100
			if(stock.getShopnum()<=100) {//��
				//������Ʒ���Ԥ����Ϣ
				request.getSession().setAttribute("msg", "���棺����Ʒ��治�㣬�뼰ʱ��ӣ�");
			}else {
				System.out.println("û����Ʒ��治��");
				//request.getSession().removeAttribute("msg");
			}
		}
		//�ж��Ƿ���ڹ���Ա
		if (!userServices.existName(username)) {//����
			//���ô�����Ϣ
			request.setAttribute("usernameErr", "�û�������");//���������Ϣ
			//����ת��
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
		
		//�жϹ���Ա�Ƿ�Ϊ��
		if (user==null) {//userΪ��ʱ
			
			request.setAttribute("passwordErr", "�������");//���������Ϣ
			//����ת��
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return;
		}
//		else {//userΪ��ʱ 
//			System.out.println("�����û�"+user+"������");
//			System.out.println("�û��������������");
//			request.setAttribute("wordname", username);
//			request.setAttribute("wordpassword", password);
//			request.setAttribute("message","�û������������");
//			//����ת��
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
//		}

		//��user����ŵ�seesion��������
		request.getSession().setAttribute("user", user);
		
		//�ض���
		response.sendRedirect(request.getContextPath()+"/jsp/user/adminmenu.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
