package primary;

public class EmailService implements MessageService {

	public void sendMessage(String message) {

		
		System.out.println("sending email : "+message);
		
	}

}
