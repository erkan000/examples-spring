package start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfigStereotypes;
import pojo.stereotype.Person;
import pojo.stereotype.PersonDetail;
import pojo.stereotype.PersonLog;

public class AppStereotypes {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigStereotypes.class);
		
		Person service = context.getBean("person", Person.class);
		System.out.println(service);
		Person service2 = context.getBean("person", Person.class);
		System.out.println(service2);
		
		PersonLog service3 = context.getBean("personLog", PersonLog.class);
		System.out.println(service3.getUser());
		
		PersonDetail service4 = context.getBean("personDetail", PersonDetail.class);
		System.out.println(service4.getPerson());
		PersonDetail service5 = context.getBean("personDetail", PersonDetail.class);
		System.out.println(service5.getLog());

	}

}
