package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pojo.User;

@Configuration
@ComponentScan("pojo")
public class AppComponent {
	
	public static void main(String[] args) {
		
		System.setProperty("user.country", "TR");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppComponent.class);
		
		User user = context.getBean("user", User.class);
		System.out.println(user + " : " + user.getName());
		System.out.println(user + " : " + user.getAge());
		System.out.println(user + " : " + user.getCountry());
		System.out.println(user + " : " + user.getLanguage());
		System.out.println(user + " : " + user.getTimeZone());
		
		context.close();

	}

}
