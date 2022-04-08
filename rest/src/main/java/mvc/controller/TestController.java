package mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import mvc.pojo.Person;

@RestController
public class TestController {

	@GetMapping("test")
	@ResponseBody
	public Person addUserForm() {				
		return new Person("er","deneme");
	}

}
