package re.validation.controller;



import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import re.validation.model.dto.ProductDTO;
import re.validation.model.dto.UserLogin;


@Controller

public class ProductController {
    @GetMapping("/")
    public String index(Model model,
                        @SessionAttribute(value = "username", required = false) String username
                        ) {

        if (username != null) {
            model.addAttribute("username", username);
            return "success";
        }

        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }


}
