package pojo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


public class PersonLog {

	
	private Person user;

	public Person getUser() {
		return user;
	}

	@Autowired
	public void setUser(Person user) {
		this.user = user;
	}
	

}
