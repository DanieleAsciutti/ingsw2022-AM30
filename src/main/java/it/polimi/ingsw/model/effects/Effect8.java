package it.polimi.ingsw.model.effects;

import it.polimi.ingsw.model.game.Game;

public class Effect8 extends Effect {
    // On the current turn, you have two more points available when calculating the influence.

    @Override
    public int getCost(){ return 2;}

    @Override
    public void effect(Game game, int playerID) {
        game.getEffectHandler().setTwopoints(playerID);
        game.setCharacterInUse(null);
    }

    @Override
    public void inizialize(Game game) {}

    @Override
    public void secondPartEffect(Game game, int playerID) {}
}
