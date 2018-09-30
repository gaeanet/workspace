package jp.tuyano.spring.sample1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyBean2 implements MyBeanInterface {
	private String message = "hello!";
	private Date date = Calendar.getInstance().getTime();

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + message + "' (" + format.format(date) + ")";
	}
	
}
