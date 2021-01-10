package start;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfigStereotypes;
import pojo.stereotype.Person;
import pojo.stereotype.PersonDetail;
import pojo.stereotype.PersonLog;

public class AppStereotypes {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigStereotypes.class);
		
		Person person = context.getBean("customPersonName", Person.class);
		System.out.println(person + " : " + person.getName());
		
		PersonLog log = context.getBean("personLog", PersonLog.class);
		System.out.println(log  + " : " + log.getPerson().getName());
		
		PersonDetail detail = context.getBean("personDetail", PersonDetail.class);
		System.out.println(detail.getPerson());
		PersonDetail detail2 = context.getBean("personDetail", PersonDetail.class);
		System.out.println(detail2.getLog());
		
		context.close();

	}

}
