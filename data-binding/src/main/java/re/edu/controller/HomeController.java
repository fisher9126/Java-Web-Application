package re.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import re.edu.model.Student;

import java.time.LocalDate;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", new Student());

        return "home";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("students")  Student student, Model model) {
        Boolean  isValid=true;
        if(student.getId()==null||!student.getId().matches("SV\\d{8}")){
            model.addAttribute("id_message","ID không hợp lệ");
            isValid=false;
        }
        if(student.getName()==null||student.getName().length()<3) {
            model.addAttribute("name_message", "Tên không hợp lệ");
            isValid = false;
        }
        if(student.getDob()==null||student.getDob().isAfter(LocalDate.now())){
            model.addAttribute("dob_message","Ngày không hợp lệ");
            isValid = false;
        }
        if(isValid){
            model.addAttribute("student", student);
            return "student";
        }
        return "home";
    }
}
