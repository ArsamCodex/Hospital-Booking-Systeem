//package Hospital.System.controller;
//
//import Hospital.System.model.Employee;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.validation.Valid;
//import java.util.jar.JarOutputStream;
//
//@Controller
//
//public class CommandController {
//
////    @GetMapping
////    public String forward(){
////        return "customerForm";
////    }
////
////    @PostMapping
////    public String processForm(@ModelAttribute("data") Customer cust){
////        System.out.println(cust.getFirstName());
////        System.out.println(cust.getLastName());
////        System.out.println(cust.getEmail());
////        return "redirect:/customerDetail";
////
////    }
//@GetMapping()
//public String getEmpForm(@ModelAttribute("emp") Employee emp){
//    return "empForm";
//}
//
//    @ModelAttribute("emp")
//    public Employee employee() {
//        return new Employee();
//    }
//
//    @PostMapping("/addEmp")
//    public String saveEmp(@ModelAttribute("emp")  Employee emp , Model model){
//
//        model.addAttribute("firstName" , emp);
////        model.addAttribute("lastName" , emp.getLastName());
////        model.addAttribute("email" , emp.getEmail());
//
//
////        emp.addFlashAttribute("savedEmployee", emp.getFirstName());
////        ra.addAttribute("savedEmployee", emp);
////        model.addAttribute("savedEmployee", emp);
//
//
//        return "empDetail";
//    }
//
////    @GetMapping("/detail")
////    public String detail(){
////        return "empDetail";
////    }
//
//}
