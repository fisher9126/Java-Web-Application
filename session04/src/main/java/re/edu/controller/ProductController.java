package re.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import re.edu.config.service.ProductService;
import re.edu.model.Product;

import java.util.List;
@Controller
public class ProductController {
    private ProductService productService;
@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String product(Model model) {
       model.addAttribute("products",productService.getProducts());
       return "product/product-list";
   }
}
