package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Client;
import be.thomasmore.party.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@Controller
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clientgreeting")
    public String clientGreeting(Model model) {
        final Optional<Client> clientFromDb = clientRepository.findById(1);
        if (clientFromDb.isPresent()) {
            String message = "%s %s%s%s".formatted(
                    getGreeting(),
                    getPrefix(clientFromDb.get()),
                    clientFromDb.get().getName(),
                    getPostfix(clientFromDb.get()));
            model.addAttribute("message", message);
        }
        return "clientgreeting";
    }

    private String getPrefix(Client client) {
        if (client.getNrOfOrders() < 10) return "";
        if (client.getNrOfOrders() < 50) return "beste ";
        return "allerliefste ";
    }

    private String getGreeting() {
        LocalDateTime now = now();
        //LocalDateTime now = LocalDateTime.parse("2023-09-23T17:15"); //for test purposes
        //NOTE: dit is de meest naieve manier om iets te testen. Volgend jaar zien we daar meer over.

        if (now.getHour() < 6) return "Goedenacht";
        if (now.getHour() < 12) return "Goedemorgen";
        if (now.getHour() < 17) return "Goedemiddag";
        if (now.getHour() < 22) return "Goedenavond";
        return "Goedenacht";
    }

    private String getPostfix(Client client) {
        if (client.getNrOfOrders() == 0) return ", en welkom!";
        if (client.getNrOfOrders() >= 80) return ", jij bent een topper!";
        return "";
    }

}
