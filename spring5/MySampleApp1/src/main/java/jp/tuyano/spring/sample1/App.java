package jp.tuyano.spring.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	private static ApplicationContext app;
		
	public static void main(String[] args) {
		app = new AnnotationConfigApplicationContext(AutoMyBeanConfig.class);
		MyBeanInterface bean = app.getBean(MyBeanInterface.class);
		System.out.println(bean);
	}

}
