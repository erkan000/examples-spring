package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.pojo.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ErrorController {
	
	private List<Person> list = new ArrayList<Person>();
	
	@GetMapping("error")
	public ModelAndView addUserForm() {				
		return new ModelAndView("errors", "person", new Person());
	}
    
    @PostMapping("error")
    public String markdown2(@ModelAttribute("person") Person person, Model model, BindingResult result) { 	
		list.add(new Person(person.getName(), person.getCity()));
		model.addAttribute("persons", list);
		
		if(person.getName().isEmpty()) {
			ObjectError error = new ObjectError("globalError", "İsim boş olamaz.");
			result.addError(error);
		}
		
    	return "errors";
    }
    
    
}
