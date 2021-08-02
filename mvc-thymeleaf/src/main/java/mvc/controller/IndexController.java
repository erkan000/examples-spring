package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Map<String, Object> model) {
    	model.put("parame", "111");
    	model.put("userName", "Erkan");
        return "index";
    }
    
    @GetMapping("/indexLayout")
    public String indexLayout(Map<String, Object> model) {
        return "indexLayout";
    }
    
    @GetMapping("/indexTemplate")
    public String indexTemplate(Map<String, Object> model) {
        return "indexTemplate";
    }

}
