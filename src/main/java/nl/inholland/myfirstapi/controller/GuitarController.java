package nl.inholland.myfirstapi.controller;


import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping(value = "guitars")
public class GuitarController {

//    @Autowired
    private GuitarService service;

    public GuitarController(GuitarService service){ //constructor
        this.service = service;
    }

    @RequestMapping(value="" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guitar>> getGuitars(){ //newly added
        return new ResponseEntity<>(service.getGuitars(), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')") //only admin can do this
    @RequestMapping(value = "",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guitar> createGuitar (@RequestBody Guitar guitar){ //newly added
        service.addGuitars(guitar);
        return new ResponseEntity<>(guitar,HttpStatus.CREATED);
    }
    //newly added
    @RequestMapping(value="{id}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) ///modified
    public ResponseEntity<Guitar> getGuitarById(@PathVariable long id){
        return new ResponseEntity<Guitar>(service.getGuitarById(id),HttpStatus.OK);
    }

    @RequestMapping(value ="brand", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)//newly added
    public ResponseEntity<List<Guitar>> getGuitarsByBrand(@RequestParam String name){
        return new ResponseEntity<List<Guitar>>((List<Guitar>) service.getGuitarsByBrand(name),HttpStatus.OK);
    }


}
