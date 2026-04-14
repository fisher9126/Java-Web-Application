package re.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import re.edu.service.UploadService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/uploads")
public class UploadController {
    @Autowired
    private UploadService uploadService;

@PostMapping
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
//    String folderUpload="/Users/cachiu/Desktop/images";
//
//    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
//
//    file.transferTo(new File(folderUpload + File.separator + fileName));
    String url=uploadService.uploadFile(file);
     model.addAttribute("url",url);

        return "result";
    }
}
