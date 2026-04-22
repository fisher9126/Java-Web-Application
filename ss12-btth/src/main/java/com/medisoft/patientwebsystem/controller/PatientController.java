package com.medisoft.patientwebsystem.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @Value("${hospital.brand.name}")
    private String name;
    @Value("${hospital.hotline}")
    private String hotline;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("hotline", hotline);
        return "index";
    }

}
