package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;




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
        String education = "Graduaat Programming";
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("city", city);
        model.addAttribute("education", education);
        return  "about";
    }

    @GetMapping("/pay")
    public String pay(Model model){
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        // Defining the format for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the current date and time
        String formattedDateAndTime = currentDateAndTime.format(formatter);
        // Add the formatted date and time to the model
        model.addAttribute("currentDateAndTime", formattedDateAndTime);

        LocalDateTime date30DaysFromNow = currentDateAndTime.plusDays(30);
        String formattedDate30DaysFromNow = date30DaysFromNow.format(formatter);
        model.addAttribute("date30daysFromNow", formattedDate30DaysFromNow);
        return "pay";
    }
}
