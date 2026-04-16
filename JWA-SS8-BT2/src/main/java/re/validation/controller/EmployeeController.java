package re.validation.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import re.validation.dto.EmployeeDto;
//Lỗi vì BindingResult phải đặt ngay sau @Valid nhưng trong code lại đặt sau Model model nên sẽ k nhận được result
@Controller
public class EmployeeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "form";
    }
    @PostMapping("/add")
    public String updateAddress(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {

            return "form";
        }
        return "success";
    }
}
