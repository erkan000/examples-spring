package config;

import java.awt.dnd.peer.DropTargetPeer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pojo.Person;
import pojo.PersonDetail;
import pojo.PersonLog;

@Configuration
public class AppConfigInjection {
	
	@Bean(name = "myPerson")
	public Person getPerson() {
		return new Person(5, "Mark");
	}
	
	@Bean(name = "myPersonLog")
	public PersonLog getPersonLog() {
		PersonLog log = new PersonLog();
		log.setUser(getPerson());
		return log;
	}
	
	@Bean(name = "myPersonDetail")
	public PersonDetail getPersonDetail() {
		PersonDetail detail = new PersonDetail(getPerson(), getPersonLog());
		return detail;
	}

}
