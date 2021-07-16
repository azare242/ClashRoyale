package sample.model.cards;

import sample.model.elements.GameElement;

public abstract class Spell implements Card{

    private double radius;
    private int cost;
    private int level;
    //protected GameElement[] gameElement;


    public Spell(double radius,int cost){
        this.radius = radius;
        this.cost = cost;
        this.level = 1;
    }
    @Override
    public abstract GameElement[] getGameElements();

    @Override
    public abstract void levelUp();
}
