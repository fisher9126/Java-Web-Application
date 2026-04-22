package re.demohackathon.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import re.demohackathon.dto.ImgFile;
import re.demohackathon.entity.Img;
import re.demohackathon.service.ImgService;
import re.demohackathon.service.UploadService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private UploadService uploadService;

    ImgService imgService;

    public HomeController(UploadService uploadService, ImgService imgService) {
        this.uploadService = uploadService;
        this.imgService = imgService;
    }

    @GetMapping("/")
    public String index(Model model) {
       List<Img> lists=imgService.getList();

        model.addAttribute("lists", lists);
        return "list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("imgFile", new ImgFile());
        return "form";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("imgFile") ImgFile imgFile, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        String url= uploadService.upload(imgFile.getImgFile());
        Img img=new Img();
        img.setUrl(url);
        img.setA(imgFile.getA());
        img.setB(imgFile.getB());
        imgService.addImg(img);
        return "redirect:/";
    }
}
