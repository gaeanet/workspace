package jp.tuyano.spring.data1;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public abstract class AbstractMyPerrsonDataDao<T> implements MyPersonDataDao<T> {
	
	public void init(){
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
	}
}
