package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pojo.Order;

@Configuration
@ComponentScan("pojo")
public class ConditionalExpressions {
	
	public static void main(String[] args) {
		
		System.setProperty("user.country", "TR");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalExpressions.class);
		
		Order or = context.getBean("order", Order.class);
		System.out.println(or.getPrice());
		System.out.println(or.getDiscount());
		System.out.println(or.getDays());
		System.out.println(or.getOrigin());
		System.out.println(or.getFormattedProperty());		
		System.out.println(or.getSummary());
		
		context.close();

	}

}
