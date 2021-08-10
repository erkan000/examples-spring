package mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mvc.pojo.Person;

@RestController
public class AjaxController {

	@GetMapping("ajax")
	public ModelAndView addUserForm() {				
		return new ModelAndView("ajax/ajax", "person", new Person());
	}

	@PostMapping("ajax")
	public ResponseEntity<?> ajaxMethod(@RequestBody Person per, Errors hata) {
		return ResponseEntity.ok(per);
	}

}
