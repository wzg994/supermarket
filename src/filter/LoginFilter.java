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
 * 管理员登入过滤器
 */
//要拦截的路径
@WebFilter(urlPatterns = { "/jsp/user/*", "/user/*" })
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse reqs = (HttpServletResponse) response;

		// 从Session作用域中获取user对象
		User user = (User) req.getSession().getAttribute("user");
		if (user != null) { // 有值
			// 放行
			chain.doFilter(request, response);
		} else {
			// 重定向到登入页面
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
