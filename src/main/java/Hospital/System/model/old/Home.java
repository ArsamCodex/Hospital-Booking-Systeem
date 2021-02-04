//package Hospital.System.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class Home {
//
//    @GetMapping
//    public String cal(@RequestParam(value="t1", required=false)  String t1,
//                           @RequestParam(value = "t2", required = false) String t2,
//                           @RequestParam(value = "mathType", required = false) String mathType,
//                           Model model) {
//        if (t1 != null && t2 != null && mathType != null) {
//            switch (mathType) {
//                case "pluss" :
//                    model.addAttribute("svar", Double.parseDouble(t1) + Double.parseDouble(t2));
//                    break;
//                case "gange" :
//                    model.addAttribute("svar", Double.parseDouble(t1) * Double.parseDouble(t2));
//                    break;
//                case "dele" :
//                    model.addAttribute("svar", Double.parseDouble(t1) / Double.parseDouble(t2));
//                    break;
//                default:
//                    break;
//
//            }
//        }
//        return "index";
//    }
//
//
//
//}
//
//
//
//
//
//
//
//
