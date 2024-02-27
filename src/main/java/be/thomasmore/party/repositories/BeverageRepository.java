package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Beverage;
import be.thomasmore.party.model.Venue;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BeverageRepository extends CrudRepository<Beverage, Integer> {


}
