package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class FirstController {

    @GetMapping("hello")
    public String hello(Map<String, Object> model) {
        model.put("message", "Hello World!");
        return "thy";
    }

}
