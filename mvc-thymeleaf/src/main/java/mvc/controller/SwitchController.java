package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class SwitchController {

    @GetMapping("/switch")
    public String hello(Map<String, Object> model) {
    	model.put("role", "user2");
        return "switch";
    }

}
