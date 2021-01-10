package pojo;

public class PersonLog {

	private Person user;
	
	public PersonLog() {
		System.out.println("PersonLog no arg const");
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		System.out.println("PersonLog setter");
		this.user = user;
	}

}
