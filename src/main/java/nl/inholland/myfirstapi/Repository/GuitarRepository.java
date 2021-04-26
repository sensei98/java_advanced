package nl.inholland.myfirstapi.Repository;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends CrudRepository<Guitar, Long> {
    Iterable<Guitar> findGuitarByBrand(String name);
}
