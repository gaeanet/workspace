package jp.tuyano.spring.data1;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/person")
public class MyPersonDataServlet extends BeanAutowiringFilterServlet {
	private static final long serialVersionUID = 1L;
		
	@Autowired
	private MyPersonDataDaoImpl dao;

	@Autowired
	private Validator validator;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<MyPersonData> list = dao.getAllEntity();
		request.setAttribute("msg", "please type my person data.");
		request.setAttribute("name", "");
		request.setAttribute("mail", "");
		request.setAttribute("age", "");
		request.setAttribute("entities", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		int age;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (NumberFormatException e) {
			age = 0;
		}
		MyPersonData entity = new MyPersonData(name, mail, age);
		Set<ConstraintViolation<MyPersonData>> result = 
				validator.validate((MyPersonData)entity);
		if (result.isEmpty()) {
			dao.addEntity(entity);
			response.sendRedirect("person");
		} else {
			String msg = "<pre>";
			for(ConstraintViolation<MyPersonData> viola : result){
				msg += viola.getPropertyPath() + ":" + viola.getMessage() + "\n";
			}
			msg += "</pre>";
			request.setAttribute("msg", msg);
			request.setAttribute("name", name);
			request.setAttribute("mail", mail);
			request.setAttribute("age", "" + age);
			request.setAttribute("entities", dao.getAllEntity());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
