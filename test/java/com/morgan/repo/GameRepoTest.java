package com.morgan.repo;

import com.morgan.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@AutoConfigureTestDatabase
@SpringBootTest
public class GameRepoTest {
    @Autowired
    private GameRepo gameRepo;

    @Test
    public void insertGames() {
        Game game = new Game();
        game.setId((long) 1);
        game.setTitle("Bloodborne");
        game.setGenre("Action");
        game.setAgeRating(16);
        game.setDeveloper("From Software");
        gameRepo.save(game);

        Game game2 = new Game();
        game.setId((long) 2);
        game.setTitle("Deathloop");
        game.setGenre("Imersive Sim");
        game.setAgeRating(18);
        game.setDeveloper("Arkane Lyon");
        gameRepo.save(game);
    }

    @Test
    public void testReadGames() {
        insertGames();
        List<Game> games = gameRepo.findAll();
        assertFalse(games.isEmpty());
        assertEquals(2, games.size());
        for (Game game : games) {
            System.out.println(game);
        }

    }
}