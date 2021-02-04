//package Hospital.System.controller;
//
//
//import Hospital.System.dto.UserRegistrationDto;
//import Hospital.System.service.UserService;
//import Hospital.System.service.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//
//public class UserController {
//
//
//    @Autowired
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        super();
//        this.userService = userService;
//    }
//
//    @ModelAttribute("user")
//    public UserRegistrationDto userRegistration() {
//        return new UserRegistrationDto();
//    }
//
//    //
//    @GetMapping
//    public String showRegistrationForm() {
//        return "registration";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userReceived, HttpSession session) {
//
//        userService.save(userReceived);
//        return "redirect:/registration?success";
//
//    }
//}
////
////
//////    @PostMapping("login")
//////    public String login2(@ModelAttribute("user") User userReceived, HttpSession session){
//////        //bestaande user is Pearl met als passwoord pw123
//////        User user = userService.getUserByPassWordAndUserName(userReceived.getUserName(), userReceived.getPassWord());
//////        if(user!= null) {
//////            System.out.println("user has logged in");
//////            session.setAttribute("currentUser", user.getUserName());
//////            return "redirect:products";
//////        }
//////        else System.out.println("not logged in");
//////        return "login";
//////    }
////
////
////}
////
////
////
////
