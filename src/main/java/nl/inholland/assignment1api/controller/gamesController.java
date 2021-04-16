package nl.inholland.assignment1api.controller;

import nl.inholland.assignment1api.model.Games;
import nl.inholland.assignment1api.service.GamesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping(value = "games")
public class gamesController {

    @Autowired
    private GamesService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Games>> getGames(){
        return ResponseEntity.status(200).body(service.getGames());
    }

    @RequestMapping(value = "",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Games> createGuitar (@RequestBody Games game){
        service.createGames(game);
        return ResponseEntity.status(201).body(game);
    }
}
