package pojo;

public class PersonDetail {
	
		private PersonLog log;
		private Person person;
		
		public void print() {
			System.out.println("Person is:" + person.getName() + ", log is :" + log.getPerson().getName());
		}
		
		public PersonDetail(Person p, PersonLog l) {
			this.person=p;
			this.log=l;
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
