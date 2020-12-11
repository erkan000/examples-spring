package start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.AppConfig;
import pojo.Person;
import pojo.PersonDetail;
import pojo.PersonLog;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Person service = context.getBean("myBean", Person.class);
		System.out.println(service);

		Person service2 = context.getBean("myBean", Person.class);
		System.out.println(service2);


		Person service3 = context.getBean("myBeanProto", Person.class);
		System.out.println(service3);

		Person service4 = context.getBean("myBeanProto", Person.class);
		System.out.println(service4);
	}

}
