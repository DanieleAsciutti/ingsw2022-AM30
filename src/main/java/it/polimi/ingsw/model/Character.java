package it.polimi.ingsw.model;

public class Character {
    private int cost;
    private boolean used;
    private final Effect effect;

    public Character(int cost, boolean used, Effect effect) {
        this.cost = cost;
        this.used = used;
        this.effect = effect;
    }

    public int getCost() {
        return cost;
    }

    public boolean isUsed() {
        return used;

    }

    public Effect getEffect() {
        return effect;
    }

    public void setUsed(boolean used) {
        this.used = used;
        cost++;
    }
}
