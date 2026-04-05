package re.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.edu.service.NotificationService;
import re.edu.service.OrderFoodService;


@Controller
public class HomeController {


    @GetMapping("home") // xử lý theo phương thức GET
    public String homePage(){

        return "home";
    }
    @GetMapping("bt1")
    public String bt1(){
        return "bt1";
    }
    @GetMapping("bt2")
    public String bt2(){
        return "bt2";
    }
    @GetMapping("/bt3")
    public String showBt3(){
        return "bt3";
    }
    @Autowired
    private OrderFoodService orderFoodService;
    @PostMapping("/order")
    public String orderFood(@RequestParam String username,
                            @RequestParam String foodName,
                            @RequestParam int quantity,
                            Model model){


        String result = orderFoodService.orderFood(username, foodName, quantity);
        model.addAttribute("message", result);

        return "bt3";
    }
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notify")
    public String notify(@RequestParam String message, Model model) {
        String result = notificationService.send(message);
        model.addAttribute("result", result);
        return "bt4";
    }

    @GetMapping("/bt4")
    public String bt4() {
        return "bt4";
    }
}