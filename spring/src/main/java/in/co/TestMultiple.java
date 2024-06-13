package in.co;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMultiple {
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext context =new ClassPathXmlApplicationContext("Multiple.xml");
		
		UserBean user = (UserBean)context.getBean("user");
		
		PersonBean person = (PersonBean)context.getBean("PersonBean");

		
		System.out.println("User Name: " + user.getLogin());
		System.out.println("User Password: " + user.getPassword());
		System.out.println("Person Name: " + person.getAddress());
		
	}

}
