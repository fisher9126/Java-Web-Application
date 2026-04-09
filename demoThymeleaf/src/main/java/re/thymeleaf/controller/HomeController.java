package re.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping()
    public String index(

    ) {

        return "hello";
    }
    @GetMapping("hello")
    public String hello( @RequestParam("a") int a,
                         @RequestParam("b") int b,
                         Model model){
        model.addAttribute("a",a);
        model.addAttribute("b",b);
        return "hello";
    }
}
