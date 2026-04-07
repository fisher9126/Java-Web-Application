package re.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import re.edu.service.EmployeeService;
import re.edu.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/employee-list";
    }
    @GetMapping("employee-list")
    public String employee( Model model) {
        List<Employee> employees=new ArrayList<Employee>();
                employees= employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "employee-list";
    }

}
