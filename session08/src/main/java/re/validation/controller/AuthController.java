package re.validation.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.validation.model.dto.UserLogin;
import re.validation.service.AuthService;

@Controller
@RequestMapping("auth")
    public class AuthController {
    @Autowired
    private AuthService authService;
        @GetMapping("login")
        public String login(Model model) {
            model.addAttribute("userLogin", new UserLogin());
        return "login";
    }


    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("userLogin") UserLogin user, Model model, HttpSession session) {
        boolean rsLogin = authService.handleLogin(user);
        if(rsLogin) {
            session.setAttribute("username", user.getUsername());
            return "redirect:/";
        }
        model.addAttribute("errorLogin", "Username or password is incorrect.");
        return "login";

    }
}
