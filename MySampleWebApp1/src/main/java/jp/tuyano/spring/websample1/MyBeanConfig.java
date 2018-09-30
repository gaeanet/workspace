package jp.tuyano.spring.websample1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jp.tuyano.spring.websampe1")
public class MyBeanConfig {

	@Beam
	public MyBean myBean() {
		return new MyBean();
	}
}
