package nl.inholland.myfirstapi.Repository;

import nl.inholland.myfirstapi.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    @Query("SELECT s.quantity * g.price FROM Stock s, Guitar g WHERE s.guitar.id = g.id AND s.guitar.id = ?1")
    int getValueOfStocksByGuitarId(Long id);
}
