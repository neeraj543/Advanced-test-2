package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuelist")
    public String venuelist(Model model) {
        final Iterable<Venue> allVenues = venueRepository.findAll();
        model.addAttribute("venues", allVenues);
        return "venuelist";
    }

    @GetMapping(value = "/venuelist", params = "outdoor")
    public String venueListOutdoor(Model model, @RequestParam boolean outdoor) {
        Iterable<Venue> venues = venueRepository.findByOutdoor(outdoor);
        model.addAttribute("venues", venues);
        model.addAttribute("filterOutdoor", outdoor ? "yes" : "no");
        return "venuelist";
    }

    @GetMapping(value = "/venuelist", params = "indoor")
    public String venueListIndoor(Model model, @RequestParam boolean indoor) {
        Iterable<Venue> venues = venueRepository.findByIndoor(indoor);
        model.addAttribute("venues", venues);
        model.addAttribute("filterIndoor", indoor ? "yes" : "no");
        return "venuelist";
    }

    @GetMapping(value = "/venuelist", params = "size")
    public String venueListSize(Model model, @RequestParam String size) {
        Iterable<Venue> venues;
        switch (size) {
            case "S":
                venues = venueRepository.findByCapacityBetween(0, 200);
                break;
            case "M":
                venues = venueRepository.findByCapacityBetween(200, 600);
                break;
            case "L":
                venues = venueRepository.findByCapacityGreaterThan(600);
                break;
            default:
                venues = venueRepository.findAll();
                size = null;
                break;
        }
        model.addAttribute("venues", venues);
        model.addAttribute("filterSize", size);
        return "venuelist";
    }

    @GetMapping({"/venuedetails/{id}", "/venuedetails"})
    public String venuedetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "venuedetails";

        Optional<Venue> venueFromDb = venueRepository.findById(id);
        //noinspection OptionalIsPresent
        if (venueFromDb.isPresent()) {
            Optional<Venue> prevVenueFromDb = venueRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevVenueFromDb.isEmpty())
                prevVenueFromDb = venueRepository.findFirstByOrderByIdDesc();
            Optional<Venue> nextVenueFromDb = venueRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextVenueFromDb.isEmpty())
                nextVenueFromDb = venueRepository.findFirstByOrderByIdAsc();

            model.addAttribute("venue", venueFromDb.get());
            model.addAttribute("prevId", prevVenueFromDb.get().getId());
            model.addAttribute("nextId", nextVenueFromDb.get().getId());
        }
        return "venuedetails";
    }
}
