package start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.PersonDetail;



public class App {

	public static void main(String[] args) {
		
		System.out.println("--- Spring Initalization ---");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("setting-setter.xml");
		
		System.out.println("--- Spring Context Ready ---");
		
		PersonDetail obj1 = context.getBean("personDetailID", PersonDetail.class);
		System.out.println("Got 1. object " + obj1);
		
		PersonDetail obj2 = context.getBean("personDetailID", PersonDetail.class);
		System.out.println("Got 2. object " + obj2);
		
		System.out.println("--- Spring context close ---");
		
		context.close();
	}

}
