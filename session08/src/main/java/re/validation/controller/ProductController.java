package re.validation.controller;

<<<<<<< HEAD
=======
import jakarta.servlet.http.HttpSession;
>>>>>>> 72b6359 (mini-project)
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.validation.model.dto.ProductDTO;

@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("products",new ProductDTO());
        return "form-add";
    }
    @PostMapping("/add")
    public String add(@Valid ProductDTO productDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "Lỗi rồi");
            return "form-add";
        }
        return "success";
    }
=======
import org.springframework.web.bind.annotation.*;
import re.validation.model.dto.ProductDTO;
import re.validation.model.dto.UserLogin;

@Controller

public class ProductController {
    @GetMapping("/")
    public String index(Model model,
                        @SessionAttribute(value = "username", required = false) String username,
                        UserLogin userLogin) {

        if (username != null) {
            model.addAttribute("username", username);
            return "success";
        }

        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

>>>>>>> 72b6359 (mini-project)
}
