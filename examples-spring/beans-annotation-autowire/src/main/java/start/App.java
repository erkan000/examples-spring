package start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import pojo.app.Person;
import pojo.app.PersonDetail;
import pojo.app.PersonLog;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonLog service = context.getBean("myBean", PersonLog.class);
		System.out.println(service);
		

		PersonDetail service2 = context.getBean("myBean2", PersonDetail.class);
		System.out.println(service2.getPerson() + " - " + service2);
	}

}
