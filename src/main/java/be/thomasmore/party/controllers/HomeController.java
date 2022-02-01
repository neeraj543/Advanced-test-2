package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("myName", "Anne Van Goethem");
        model.addAttribute("myStreet", "Koning Albertlaan 23");
        model.addAttribute("myCity", "Leuven");
        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        LocalDateTime now = now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        model.addAttribute("today", formatter.format(now));
        model.addAttribute("payday", formatter.format(now.plusDays(30)));
        model.addAttribute("isWeekend", now.getDayOfWeek() == DayOfWeek.SATURDAY || now.getDayOfWeek() == DayOfWeek.SUNDAY);
        return "pay";
    }
}
