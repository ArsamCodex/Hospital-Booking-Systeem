package Hospital.System.controller;

import Hospital.System.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

    @Autowired
    UserDAO userDAO;

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
}
