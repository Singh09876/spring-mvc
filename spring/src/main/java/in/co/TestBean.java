package in.co;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestBean {

	
	
	
	public static void main(String[] args) {
		
		


		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("UserBean.xml"));

		UserBean bean = (UserBean) factory.getBean("user");

		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());

		
		
	}
}
