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

import beans.Supadmin;
/*
 * ��������Ա��¼������
 */
@WebFilter(urlPatterns = { "/jsp/supmanger/*" })
public class SupmangerFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ǿת
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse reqs = (HttpServletResponse) response;

		// ��Session�������л�ȡuser����
		Supadmin supadmin = (Supadmin) req.getSession().getAttribute("supadmin");
		if (supadmin != null) { // ��ֵ
			// ����
			chain.doFilter(request, response);
		} else {
			// �ض��򵽵���ҳ��
			reqs.sendRedirect(req.getContextPath() + "/jsp/suplogin.jsp");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
