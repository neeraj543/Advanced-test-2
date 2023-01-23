package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artistlist")
    public String artistList(Model model) {
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists", artists);
        return "artistlist";
    }

    @GetMapping({"/artistdetails/{id}", "/artistdetails"})
    public String artistDetails(Model model,
                                @PathVariable(required = false) Integer id) {
        if (id == null) return "artistdetails";

        Optional<Artist> optionalArtist = artistRepository.findById(id);
        //noinspection OptionalIsPresent
        if (optionalArtist.isPresent()) {
            Optional<Artist> prevArtistFromDb = artistRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevArtistFromDb.isEmpty())
                prevArtistFromDb = artistRepository.findFirstByOrderByIdDesc();
            Optional<Artist> nextArtistFromDb = artistRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextArtistFromDb.isEmpty())
                nextArtistFromDb = artistRepository.findFirstByOrderByIdAsc();

            model.addAttribute("artist", optionalArtist.get());
            model.addAttribute("prevId", prevArtistFromDb.get().getId());
            model.addAttribute("nextId", nextArtistFromDb.get().getId());
        }
        return "artistdetails";
    }

}
