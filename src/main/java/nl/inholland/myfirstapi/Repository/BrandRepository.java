package nl.inholland.myfirstapi.Repository;

import nl.inholland.myfirstapi.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long> {
    Brand findBrandByName(String name);
}
