package sample.model.cards;

import sample.model.elements.GameElement;

public abstract class Building implements Card{

    private int level;
    private int cost;
    //protected GameElement gameElement;


    public Building(int cost){
        this.level = 1;
        this.cost = cost;
    }

    @Override
    public abstract GameElement[] getGameElements() ;

    @Override
    public abstract void levelUp();
}
