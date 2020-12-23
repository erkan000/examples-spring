package pojo.app;

import org.springframework.beans.factory.annotation.Autowired;


public class PersonLog {
	
	private Person user;
	
	public PersonLog() {
		System.out.println("*** Person Log Created: No-args const");
	}

	public Person getUser() {
		return user;
	}

	@Autowired
	public void setUser(Person user) {
		System.out.println("*** Person INJECTED to PersonLog: By setter");
		this.user = user;
	}
	

}
