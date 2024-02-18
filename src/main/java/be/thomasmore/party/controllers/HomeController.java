package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model){
        int myCalculatedValue = 34 * 628;
        model.addAttribute("myCalculatedValue", myCalculatedValue);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        String name= "Neeraj";
        String address = "Belgelei 59";
        String city = "Antwerpen";
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        return  "about";
    }

}
