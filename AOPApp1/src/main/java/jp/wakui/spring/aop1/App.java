package jp.wakui.spring.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	private static ApplicationContext app;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		app  =new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		IMyBean<String> bean = (IMyBean<String>) app.getBean("bean1");
		bean.addData("Hello AOP world!");
		bean.addData("this is sample data");

		System.out.println(bean.toStgring());
		
		IMyBean<String> bean2 = (IMyBean<String>) app.getBean("bean2");
		bean2.addData(1);
		bean2.addData(3);

		System.out.println(bean2.toStgring());
	}

}
