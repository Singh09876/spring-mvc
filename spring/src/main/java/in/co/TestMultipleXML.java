package in.co;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultipleXML {
	
	
	
	public static void main(String[] args) {
		
		
		ApplicationContext context =new ClassPathXmlApplicationContext(new String[] {"UserBean.xml","Person.xml"});
		
		UserBean user =(UserBean) context.getBean("user");
		
		
		System.out.println(user.getLogin());
		System.out.println(user.getPassword());
		
		
		PersonBean person =(PersonBean)context.getBean("PersonBean");
		
		System.out.println(person.getAddress());
		
	}

}
