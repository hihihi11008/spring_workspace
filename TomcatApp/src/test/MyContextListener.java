package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * ���ϰ� ���� ��û�� �����⵵ ���� ������, �� ������ �����ϴ� ������ �̺�Ʈ�� ������ �� �ִ� 
 * ServletContextListener�� �̿��Ͽ� , ServletContext ��ü�� ���𰡸� �۾��غ���!! 
 * */
public class MyContextListener implements ServletContextListener{

	//���ø����̼��� �ʱ�ȭ �ɶ� ȣ��Ǵ� �޼���
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("���ø����̼� ���� ���۰��Բ� �����Ǿ����ϴ�");
		//���ø����̼��� ������ ������ ����, ���Ǻ��ٵ� �ξ� ������ư��� ServletConext�� 
		//����Ͻ���ü��(service, DAO..)�� �ø���!
		ServletContext context = sc.getServletContext();
		context.setAttribute("msg", "�� �����");
		
		String contextConfigLocation=context.getInitParameter("contextConfigLocation");
		System.out.println("���ø����̼� �����ɶ� �޸𸮿� �÷��� ����� "+ contextConfigLocation);
	}


	//���ø����̼��� ���� �ɶ� ȣ��Ǵ� �޼���
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("���ø����̼� ��������� �Բ� ����Ǿ����ϴ�");
		
	}


}
