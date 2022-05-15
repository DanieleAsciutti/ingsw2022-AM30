package it.polimi.ingsw.model.effects;

import it.polimi.ingsw.exceptions.InvalidStopException;
import it.polimi.ingsw.exceptions.InvalidStudentEffectException;
import it.polimi.ingsw.model.game.Game;

public class Effect2 extends Effect {
    // Take control of the professors even if you have the same number of students
    // in the hall as the player currently controlling them.

    @Override
    public int getCost(){ return 2;}

    @Override
    public String getName(){ return "FARMER";}

    @Override
    public void effect(Game game, int playerID)  throws InvalidStopException {
        game.getEffectHandler().setProfessorcontroll(true);
        game.setCharacterInUse(null);
    }

    @Override
    public void inizialize(Game game) {}

    @Override
    public void secondPartEffect(Game game, int playerID)  throws InvalidStudentEffectException {}
}
