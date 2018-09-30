package jp.tuyano.spring.sample2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class MyPropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor dateEditor = new CustomDateEditor(format, false);
		registry.registerCustomEditor(Date.class, dateEditor);
		MyBeanTypeEditor myBeanEditor = new MyBeanTypeEditor();
		registry.registerCustomEditor(MyBean.class, myBeanEditor);
	}

}
