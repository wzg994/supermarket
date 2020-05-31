package filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * 监听服务器  
 * 获取项目路径
 */

@WebListener
public class Lisener implements ServletContextListener {

	/*
	 * 监听服务器初始化方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("服务器启动了");
		// 获取项目名
		String path = sce.getServletContext().getContextPath();
		System.out.println("项目名:" + path);

		// 把项目名放到application作用域中
		sce.getServletContext().setAttribute("path", path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
