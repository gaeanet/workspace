package jp.tuyano.spring.data1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class BeanAutowiringFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	MyPersonDataDaoRepository repository;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport
			.processInjectionBasedOnCurrentContext(this);
	}

}
