package nl.inholland.myfirstapi.controller;


import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(value = "guitars")
public class GuitarController {

    @Autowired
    private GuitarService service;

    @RequestMapping(value="" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guitar>> getGuitars(){
        return ResponseEntity.status(200).body(service.getGuitars());
    }

    @RequestMapping(value = "",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guitar> createGuitar (@RequestBody Guitar guitar){
        service.createGuitars(guitar);
        return ResponseEntity.status(201).body(guitar);
    }
    //newly added
    @GetMapping(value="/{id}")
    public Guitar getGuitarById(@PathVariable long id){
        return service.getGuitarById(id);
    }
}
