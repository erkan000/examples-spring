package pojo.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonDetail {
	
		@Autowired
		private PersonLog log;
		
		@Autowired
		private Person person;
		
		public void print() {
			System.out.println("Person is:" + person.getName() + ", log is :" + log.getUser().getName());
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
