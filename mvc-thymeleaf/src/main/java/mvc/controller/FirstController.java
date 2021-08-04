package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Map;

@Controller
public class FirstController {

    @GetMapping("hello")
    public String hello(Map<String, Object> model) {
        model.put("message", "Hello World!");
        model.put("today", Calendar.getInstance());
        return "thy";
    }

}
