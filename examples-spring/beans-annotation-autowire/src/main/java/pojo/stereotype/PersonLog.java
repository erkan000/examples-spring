package pojo.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class PersonLog {

	@Autowired
	private Person user;

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}
	

}
