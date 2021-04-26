package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.Repository.GuitarRepository;
import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarServiceImpl implements GuitarService{

//service needs to save something to the database
//autowiring the repository
    @Autowired
    private GuitarRepository guitarRepository;

    public Guitar addGuitars(Guitar guitar){ //for post //addguitar
        //saving to database
        guitarRepository.save(guitar);
        return guitar;
    }

    public List<Guitar> getGuitars() { //for get

        return (List<Guitar>) guitarRepository.findAll();
    }
    public Guitar getGuitarById(long id){
        return guitarRepository.findById(id).get();
    }

    @Override
    public List<Guitar> getGuitarsByBrand(String name) {
        return (List<Guitar>) guitarRepository.findGuitarByBrand(name);
    }
}
