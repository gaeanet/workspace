package jp.tuyano.spring.data1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="mypersondata")
public class MyPersonData {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length=50, nullable=false)
	@NotEmpty(message="必須項目です。")
	private String name;
	
	@Column(length=100, nullable=true)
	@NotEmpty(message="必須項目です。")
	@Email(message="メールアドレスが必要です。")
	private String mail;
	
	@Column(nullable=true)
	@Min(value=0, message="{value}以上でなければいけません。")
	@Max(value=150, message="{value}以下でなければいけません。")
	private int age;

	public MyPersonData() {
		super();
	}
	
	public MyPersonData(String name, String mail, int age) {
		this();
		this.name = name;
		this.mail = mail;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MyPersonData [id=" + id + ", name=" + name + ", mail=" + mail + ", age=" + age + "]";
	}

}
