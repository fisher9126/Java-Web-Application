package re.validation.service;

import org.springframework.stereotype.Service;
import re.validation.model.dto.UserLogin;
@Service
public class AuthService {
    public boolean handleLogin(UserLogin userLogin) {
        if(userLogin.getUsername().equals("admin") && userLogin.getPassword().equals("123123")) {
            return true;
        }
        return false;
    }
}
