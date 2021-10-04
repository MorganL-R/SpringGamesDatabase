package com.morgan.api;

import com.morgan.model.Game;
import com.morgan.repo.GameRepo;
import com.sun.xml.bind.v2.model.core.ID;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GamesController {


    /**
     * Games Controller API listings
     */
    @Autowired
    private GameRepo gameRepo;

    /**
     *
     * POST API
     *
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> createGame(@RequestBody Game game){
        gameRepo.save(game);
        return new ResponseEntity<>(game.getId(), HttpStatus.CREATED);
    }

    /**
     *
     * GET GAME BY ID API
     *
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Game getGame(@PathVariable Long id){
        return gameRepo.getById(id);
    }

    /**
     *
     * PUT API
     *
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGame(@RequestBody Game game){
        if (game.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        gameRepo.save(game);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * DELETE API
     *
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        if (gameRepo.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     * GET ALL GAMES API
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameRepo.findAll();
        if (games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

}
