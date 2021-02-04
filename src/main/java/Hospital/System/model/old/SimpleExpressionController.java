//package Hospital.System.controller;
//
//
//import Hospital.System.model.Address;
//import Hospital.System.model.Person;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class SimpleExpressionController {
//
//    @GetMapping("/simpleexpresion")
//    public String simpleExpression(Model model){
//        Address address = new Address("Is Java Intresse?!", "8510003");
//        Person tina = new Person(1, "Mr ArsaM - Follow Me  ", address);
//        model.addAttribute("person", tina);
//        return "simpleExpresion";
//
//    }
//}
