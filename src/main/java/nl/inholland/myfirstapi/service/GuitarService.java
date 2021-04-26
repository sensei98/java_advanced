package nl.inholland.myfirstapi.service;
import nl.inholland.myfirstapi.model.Guitar;
import java.util.List;


public interface GuitarService {
    Guitar addGuitars(Guitar guitar);
    List<Guitar> getGuitars();
    Guitar getGuitarById(long id);
    List<Guitar> getGuitarsByBrand(String name);
}
