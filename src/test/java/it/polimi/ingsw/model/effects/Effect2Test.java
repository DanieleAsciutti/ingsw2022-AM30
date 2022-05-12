package it.polimi.ingsw.model.effects;

import it.polimi.ingsw.exceptions.InvalidStopException;
import it.polimi.ingsw.model.game.Game;
import it.polimi.ingsw.model.game.GameMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Effect2Test {

    Effect effect2 = new Effect2();

    Game game2players = new Game(GameMode.EXPERTMODE,2, null);
    Game game3players = new Game(GameMode.EXPERTMODE,3, null);

    @BeforeEach
    void init() {
        game2players.addPlayer("Daniele");
        game2players.addPlayer("Giuseppe");
        game3players.addPlayer("Daniele");
        game3players.addPlayer("Giuseppe");
        game3players.addPlayer("Samuele");
    }

    @Test
    void getCost() {
        assertEquals(2,effect2.getCost());
    }

    @Test
    void effect() throws InvalidStopException {
        // Test 2 Players Game
        assertFalse(game2players.getEffectHandler().isProfessorcontroll());
        effect2.effect(game2players,1);
        assertTrue(game2players.getEffectHandler().isProfessorcontroll());

        // Test 3 Players Game
        assertFalse(game3players.getEffectHandler().isProfessorcontroll());
        effect2.effect(game3players,1);
        assertTrue(game3players.getEffectHandler().isProfessorcontroll());
    }
}