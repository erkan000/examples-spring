package start;

import java.util.Calendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfigFactoryBean;

public class AppFactoryBean {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigFactoryBean.class);
		
		Calendar b1 = context.getBean("cal", Calendar.class);
		System.out.println(b1.getTimeInMillis());
		
		context.close();
		
	}
		
}
