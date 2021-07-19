package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;

public abstract class Spell implements Card{

    private double radius;
    private int cost;
    protected int level;
    protected GameElement[] gameElements;


    public Spell(double radius,int cost){
        this.radius = radius;
        this.cost = cost;
        this.level = 1;
    }
    @Override
    public abstract GameElement[] getGameElements();

    @Override
    public abstract void levelUp();

    @Override
    public int getCost(){
        return cost;
    }

    @Override
    public abstract Image getDefaultImage(String side);
}
