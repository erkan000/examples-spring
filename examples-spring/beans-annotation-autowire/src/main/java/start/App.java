package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import pojo.app.PersonDetail;
import pojo.app.PersonLog;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonLog b1 = context.getBean("myBean", PersonLog.class);
		System.out.println(b1.getUser());		

		PersonDetail b2 = context.getBean("myBean2", PersonDetail.class);
		System.out.println(b2.getPerson() + " - " + b2);
		
		context.close();
	}

}
