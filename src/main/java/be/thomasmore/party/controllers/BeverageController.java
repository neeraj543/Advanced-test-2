package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import be.thomasmore.party.repositories.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class BeverageController<Beverage> {
    private BeverageRepository beverageRepository;
        @GetMapping("/beverageList")
           public String artistList(Model model) {
            Iterable<Beverage> beverages = (Iterable<Beverage>) beverageRepository.findAll();
            model.addAttribute("beverage", beverages);
            return "beverageList";
        }
}
