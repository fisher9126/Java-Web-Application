package re.validation.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
}
