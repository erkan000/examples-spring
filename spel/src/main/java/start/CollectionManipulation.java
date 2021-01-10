package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pojo.Cargo;

@Configuration
@ComponentScan("pojo")
public class CollectionManipulation {
	
	public static void main(String[] args) {
		
		System.setProperty("user.country", "TR");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollectionManipulation.class);
		
		Cargo car = context.getBean("cargo", Cargo.class);
		System.out.println(car.getShippingLocations());
		System.out.println(car.getNoOfCheapShippingLocations());
		System.out.println(car.getNonCapitalShippingLocations());
		System.out.println(car.getWesternShippingLocations());
		
		context.close();

	}

}
