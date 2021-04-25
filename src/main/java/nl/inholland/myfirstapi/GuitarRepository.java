package nl.inholland.myfirstapi;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.data.repository.CrudRepository;

public interface GuitarRepository extends CrudRepository<Guitar, Long> {

}
