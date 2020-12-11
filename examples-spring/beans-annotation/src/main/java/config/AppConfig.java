package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pojo.Person;

@Configuration
public class AppConfig {
	
	@Bean(name = "myBean")
	public Person test() {
		return new Person(2, "Test");
	}
	
	@Bean(name = "myBeanProto")
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public Person test2() {
		return new Person(1, "Erkan");
	}

}
