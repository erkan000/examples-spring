package start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Person;
import pojo.PersonDetail;
import pojo.PersonLog;

public class App {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-settings.xml");
		
		Person person = context.getBean("person", Person.class);
		System.out.println(person + " " + person.getName());
		
		PersonLog log = context.getBean("personLogID", PersonLog.class);
		Person personLog = log.getPerson();
		personLog.print();

		PersonDetail detail = context.getBean("personDetailID", PersonDetail.class);
		detail.print();
		
		PersonLog log2 = context.getBean("personByName", PersonLog.class);
		Person personLog2 = log2.getPerson();
		personLog2.print();

		context.close();
	}

}
