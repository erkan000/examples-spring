package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IfController {

    @GetMapping("/if")
    public String hello(Map<String, Object> model) {
    	model.put("count", "5");
        return "if";
    }

}
