package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.pojo.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrudController {
	
	private List<Person> list = new ArrayList<Person>();
	
	@GetMapping("crud")
	public ModelAndView addUserForm() {				
		return new ModelAndView("crud", "person", new Person());
	}
    
    @PostMapping("crud")
    public String markdown2(@ModelAttribute("person") Person person, Model model) { 	
		list.add(new Person(person.getName(), person.getCity()));
		model.addAttribute("persons", list);
    	return "crud";
    }
    
    
}
