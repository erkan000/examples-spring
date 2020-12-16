package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import pojo.Person;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Person service = context.getBean("myBean", Person.class);
		System.out.println(service);

		Person service2 = context.getBean("myBean", Person.class);
		System.out.println(service2);


		Person service3 = context.getBean("myBeanProto", Person.class);
		System.out.println(service3);

		Person service4 = context.getBean("myBeanProto", Person.class);
		System.out.println(service4);
		
		context.close();
	}

}
