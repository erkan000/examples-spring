package start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Person;
import pojo.PersonDetail;
import pojo.PersonLog;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");
		
		
		PersonLog service = context.getBean("personLogID", PersonLog.class);
		
		Person nesne1 = service.getUser();
		
		nesne1.print();
		
		System.out.println(nesne1.toString());
		Person nesne2  = service.getUser();
		System.out.println(nesne2.toString());
		Person nesne3 = service.getUser();
		System.out.println(nesne3.toString());

		/**
			tr.dao.UserDAO@5419f379
			tr.dao.UserDAO@5419f379
			tr.dao.UserDAO@5419f379
		 **/
		
		PersonDetail detail = context.getBean("personDetailID", PersonDetail.class);
		
	detail.print();
		
		
		
		context.close();

	}

}
