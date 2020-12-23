package pojo.app;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonDetail {	

	private Person person;
	
	public PersonDetail() {
		System.out.println("*** Person Detail Created: No-args const");
	}

	@Autowired
	public PersonDetail(Person person) {
		System.out.println("*** Person INJECTED to PersonDetail: By const");
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
