package sample.model.cards;

import sample.model.elements.GameElement;

public abstract class Troop implements Card{

    private int level;
    private int count;
    private int cost;
    //protected GameElement[] gameElement;
    public Troop(int count,int cost){
        this.cost = cost;
        this.count = count;
        this.level = 1;
    }
    @Override
    public abstract GameElement[] getGameElements();

    @Override
    public abstract void levelUp();
}
