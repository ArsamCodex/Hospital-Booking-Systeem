//package Hospital.System.controller;
//
//import Hospital.System.model.Customer;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class CommandController {
//
//    @GetMapping
//    public String forward() {
//
//        return "customerform";
//    }
//
//    @ModelAttribute("customer")
//    public Customer customer(){
//        return new Customer();
//    }
//
//    //NOW WE CAN HIER ALSO SAVE THIS DATA TO DATABASE
//    //ITS LIKE PHISHING?! YES
//    // BCryptPasswordEncoder() TO  HASH PASSWORDS
//
//    @PostMapping("/register")
//    public String processForm(@ModelAttribute("customer")  Customer cust , Model mode){
//
//                mode.addAttribute("cus1" , cust.getFirstName() );
//                mode.addAttribute("cus2" , cust.getLastName() );
//                 mode.addAttribute("cus3" , cust.getStreet());
//                mode.addAttribute("cus4" , cust.getEmail() );
////                mode.addAttribute("cus" , cust.getCountry() );
////                mode.addAttribute("cus" , cust.getPlace());
//
//
//
//        return "customerdetail";
//
//
//    }
//
//    }
//
