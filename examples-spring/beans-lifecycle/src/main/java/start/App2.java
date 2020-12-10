package start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.PersonDetail;



public class App2 {

	public static void main(String[] args) {
		
		System.out.println("--- Spring Initalization ---");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("setting-constructor.xml");
		
		System.out.println("--- Spring Context Ready ---");
		
		context.getBean("personDetailID", PersonDetail.class);
		
		System.out.println("--- Spring context close ---");
		
		context.close();
	}

}
