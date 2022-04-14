package it.polimi.ingsw.model.effects;

import it.polimi.ingsw.model.game.Game;

public class Effect2 extends Effect {
    // Take control of the professors even if you have the same number of students
    // in the hall as the player currently controlling them.
    private int cost = 2;

    @Override
    public int getCost(){ return cost;}
    @Override
    public void effect(Game game, int playerID) {
        game.getVerifyType().setProfessorcontroll(true);
    }
}
