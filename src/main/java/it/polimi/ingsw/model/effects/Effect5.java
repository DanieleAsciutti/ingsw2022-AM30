package it.polimi.ingsw.model.effects;

import it.polimi.ingsw.exceptions.InvalidStopException;
import it.polimi.ingsw.exceptions.WrongStudentEffectException;
import it.polimi.ingsw.model.game.Game;
import it.polimi.ingsw.model.player.PlayerState;

public class Effect5 extends Effect {
    // Place a ban on an island of your choice.
    // The first time Mother Nature moves there the ban falls and does not calculate the influence there.
    // The bans can be a maximum of 4.
    private PlayerState prevPlayerState;

    @Override
    public int getCost(){ return 2;}

    @Override
    public void effect(Game game, int playerID)  throws InvalidStopException{
        if(game.getEffectHandler().getNumofislandstops()>0) {
            prevPlayerState = game.getPlayer(playerID).getPlayerState();
            game.getPlayer(playerID).setPlayerState(PlayerState.CHARACTHERISLANDPHASE);
        }
        else
             throw new InvalidStopException();
    }

    @Override
    public void inizialize(Game game) {}

    @Override
    public void secondPartEffect(Game game, int playerID) throws WrongStudentEffectException {
        game.getBoard().getArchipelago().getSingleIsland(game.getEffectHandler().getIslandIDchoose()).setStop(true);
        game.getEffectHandler().removeislandstop();
        game.setCharacterInUse(null);
        game.getPlayer(playerID).setPlayerState(prevPlayerState);
    }
}
