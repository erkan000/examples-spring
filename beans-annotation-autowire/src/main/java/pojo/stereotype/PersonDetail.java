package pojo.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDetail {

	@Autowired
	private PersonLog log;

	@Autowired
	private Person person;
	
	public PersonDetail() {
		System.out.println("*** PersonDetail created: const");
	}

	public void print() {
		System.out.println("Person is:" + person.getName() + ", log is :" + log.getPerson().getName());
	}

	public PersonLog getLog() {
		return log;
	}
	public void setLog(PersonLog log) {
		this.log = log;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
