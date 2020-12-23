package pojo.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonLog {
	
	private Person person;	
	
	public PersonLog() {
		System.out.println("*** PersonLog created: No-args const");
	}
	
	@Autowired
	public PersonLog(Person person) {
		System.out.println("*** PersonLog created: with person const");
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		System.out.println("*** Person INJECTED to PersonLog: By setter");
		this.person = person;
	}	

}
