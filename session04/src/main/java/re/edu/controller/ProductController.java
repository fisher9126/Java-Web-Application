package re.edu.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai4")
public class ProductController {

    @GetMapping("/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap model
    ) {
        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tim kiem thanh cong");

        return "product/product-list";
    }
}