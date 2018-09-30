package jp.tuyano.spring.websample1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
	private List<String> messages = new ArrayList<String>();
	
	public MyBean() {
		super();
		messages.add("This is Bean Samples!");
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public String getMessage(int n) {
		return messages.get(n);
	}
	
	public void setMessage(int n , String message) {
		this.messages.add(n , message);
	}
	
	@Override
	public String toString() {
		String result = "My Bean [\n";
		for(String message : this.messages) {
			result += "\t" + message + "\n";
		}
		
		return result;
	}
	
	

	
}
