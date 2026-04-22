package re.orm_hibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import re.orm_hibernate.service.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("products", productService.getALl());
        return "index";
    }
}
