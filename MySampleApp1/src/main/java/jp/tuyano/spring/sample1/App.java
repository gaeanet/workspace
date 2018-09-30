package jp.tuyano.spring.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static ApplicationContext app;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		app  = new AnnotationConfigApplicationContext(AutoMyBeanConfig.class);
		MyBeanInterface bean = (MyBeanInterface)app.getBean(MyBeanInterface.class);
		//		MyBeanInterface bean = app.getBean(MyBean.class);
		System.out.println(bean);
	}

}
