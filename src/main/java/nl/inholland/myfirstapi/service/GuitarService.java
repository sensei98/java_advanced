package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.GuitarRepository;
import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuitarService {
//    private List<Guitar> guitars = new ArrayList<>();
//service needs to save something to the database
//autowiring the repository
    @Autowired
    private GuitarRepository guitarRepository;

//    public GuitarService(){
//        this.guitars = new ArrayList<>(
//                List.of(
//                        new Guitar("Fender","Stratocaster", 1650.00),
//                        new Guitar("Gibson","Firebird",2000.00),
//                        new Guitar("Fender", "Telecaster", 1980.00)
//                )
//        );
//    }

    public Guitar createGuitars(Guitar guitar){ //for post
//        guitars.add(guitar);
        //saving to database
        guitarRepository.save(guitar);
        return guitar;
    }

    public List<Guitar> getGuitars() { //for get
        return (List<Guitar>) guitarRepository.findAll();
    }
    public Guitar getGuitarById(long id){
        return guitarRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
