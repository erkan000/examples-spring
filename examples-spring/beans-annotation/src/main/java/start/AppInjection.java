package start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import config.AppConfigInjection;
import pojo.Person;
import pojo.PersonDetail;
import pojo.PersonLog;

public class AppInjection {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigInjection.class);
		
		Person service = context.getBean("myPerson", Person.class);
		System.out.println(service + " - " +service.getName());
		
		PersonLog service2 = context.getBean("myPersonLog", PersonLog.class);
		System.out.println(service2 + " - " +service2.getUser());

		PersonDetail service3 = context.getBean("myPersonDetail", PersonDetail.class);
		System.out.println(service3 + " - " +service3.getPerson() + " - " +service3.getLog());
		
	}

}
