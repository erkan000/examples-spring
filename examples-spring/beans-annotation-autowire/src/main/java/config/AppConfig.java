package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pojo.app.Person;
import pojo.app.PersonDetail;
import pojo.app.PersonLog;


@Configuration
//@ComponentScan("pojo.app")
public class AppConfig {
	

	@Bean(name = "myBean")
	public PersonLog test() {
		return new PersonLog();
	}
	
	@Bean
	public Person nn() {
		return new Person();
	}

	@Bean(name = "myBean2")
	public PersonDetail test2() {
		return new PersonDetail();
	}
}
