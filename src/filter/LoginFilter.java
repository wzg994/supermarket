package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/*
 * ����Ա���������
 */
//Ҫ���ص�·��
@WebFilter(urlPatterns = { "/jsp/user/*", "/user/*" })
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ǿת
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse reqs = (HttpServletResponse) response;

		// ��Session�������л�ȡuser����
		User user = (User) req.getSession().getAttribute("user");
		if (user != null) { // ��ֵ
			// ����
			chain.doFilter(request, response);
		} else {
			// �ض��򵽵���ҳ��
			reqs.sendRedirect(req.getContextPath() + "/jsp/login.jsp");
		}

	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
