package re.demohkt.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.demohkt.model.dto.ProductDTO;
import re.demohkt.model.entity.Product;
import re.demohkt.service.ProductService;
import re.demohkt.service.UploadService;

import java.io.IOException;

@Controller
public class HomeController {
    private ProductService productService;
    private UploadService  uploadService;

    public HomeController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products",productService.findAll());
        return "list";
    }@GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product",new ProductDTO());
        return "form";
    }
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult result, Model model) throws IOException {
        if (product.getUrl() == null || product.getUrl().isEmpty()) {
            result.rejectValue("url", "error.url", "Phải chọn ảnh");
        }
        if(result.hasErrors()){
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            return "form";
        }
        String url=uploadService.upload(product.getUrl());
        Product newProduct=new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setUrl(url);
        productService.addProduct(newProduct);
        return  "redirect:/";

    }
    @GetMapping("delete")
    public String deleteProduct(@RequestParam("id")String id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @GetMapping("edit")
    public String editProduct(@RequestParam("id") String id,Model model){
        ProductDTO productDTO=new ProductDTO();
        Product product=productService.findById(id);
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        model.addAttribute("product", productDTO);
        return "edit-form";
    }
    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult result, Model model) throws IOException {
        if (product.getUrl() == null || product.getUrl().isEmpty()) {
            result.rejectValue("url", "error.url", "Phải chọn ảnh");
        }
        if(result.hasErrors()){
            System.out.println(product.getName());
            System.out.println(product.getDescription());
            return "edit-form";
        }
        String url=uploadService.upload(product.getUrl());
        Product newProduct=new Product();
        newProduct.setId(product.getId());
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setUrl(url);
        System.out.println(newProduct.getId());
        System.out.println(newProduct.getName());
        System.out.println(newProduct.getDescription());
        productService.updateProduct(newProduct);
        return  "redirect:/";

    }

}
