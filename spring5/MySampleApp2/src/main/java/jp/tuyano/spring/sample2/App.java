package jp.tuyano.spring.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext app;
	
	public static void main(String[] args) {
		app = new ClassPathXmlApplicationContext("classpath:/bean.xml");
		MyBean bean = (MyBean) app.getBean("bean1");
		System.out.println(bean);
		MyBeanKeeper beankeeper = (MyBeanKeeper) app.getBean("beankeeper1");
		System.out.println(beankeeper);
	}
}

