package jp.tuyano.spring.sample1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyBean2 implements MyBeanInterface {

	private Date date;
	private String message;
	
	public MyBean2() {
		super();
		this.date = Calendar.getInstance().getTime();
	}
	
	public MyBean2(String message) {
		this();
		this.message  =message;
	}

	/* (non-Javadoc)
	 * @see jp.tuyano.spring.sample1.MyBeanInterface#getDate()
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see jp.tuyano.spring.sample1.MyBeanInterface#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see jp.tuyano.spring.sample1.MyBeanInterface#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddd");
		return "MyBean2 [message=" + message + "date=" + format.format(date) + "]";
	}

}
