package pojo;

public class PersonDetail {

	private PersonLog log;
	private Person person;
	
	public PersonDetail() {
		System.out.println("PersonDetail no arg const");
	}

	public PersonDetail(Person person, PersonLog log) {
		System.out.println("PersonDetail arguman constructor");
		this.log =log;
		this.person = person;
	}

	public void print() {
		System.out.println("Person is:" + person.getName() + ", log is :" + log.getUser().getName());
	}		
	public PersonLog getLog() {
		return log;
	}
	public Person getPerson() {
		return person;
	}

}
