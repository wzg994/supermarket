package filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * ����������  
 * ��ȡ��Ŀ·��
 */

@WebListener
public class Lisener implements ServletContextListener {

	/*
	 * ������������ʼ������
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("������������");
		// ��ȡ��Ŀ��
		String path = sce.getServletContext().getContextPath();
		System.out.println("��Ŀ��:" + path);

		// ����Ŀ���ŵ�application��������
		sce.getServletContext().setAttribute("path", path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
