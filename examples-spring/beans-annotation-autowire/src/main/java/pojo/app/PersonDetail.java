package pojo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class PersonDetail {
	
		
		private Person person;
		
		public PersonDetail() {
			// TODO Auto-generated constructor stub
		} 
		
		@Autowired
		public PersonDetail(Person person) {
			this.person = person;
		}
		
		
		
		
		public Person getPerson() {
			return person;
		}
		public void setPerson(Person person) {
			this.person = person;
		}

}
