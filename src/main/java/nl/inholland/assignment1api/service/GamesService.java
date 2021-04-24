package nl.inholland.assignment1api.service;

import nl.inholland.assignment1api.model.Games;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GamesService {
    private List<Games> games = new ArrayList<>();

    public GamesService() {
        this.games = new ArrayList<>(
                List.of(
                        new Games("FIFA20","football",90.00),
                        new Games("Call of duty","action",50.80),
                        new Games("Formula 1","racing",90.90),
                        new Games("NBA","basketball",40.90)
                )
        );
    }
    public Games createGames(Games game){
        games.add(game);
        return game;
    }

    public List<Games> getGames() {
        return games;
    }


    public List<Games> updateGames(Games newGame){
        for(Games game: games){

            game.setName(newGame.getName());
            game.setPrice(newGame.getPrice());
            game.setType(newGame.getType());
        }
        games.add(newGame);
        return games;
    }
    public  List<Games> deletegames(Games game){
        for(Games x: games ){
            if(x.getUuid() == game.getUuid()){
                games.remove(x);
            }
        }
        return games;
    }

}
