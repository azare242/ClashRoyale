package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;

public abstract class Troop implements Card{

    protected int level;
    private int count;
    private int cost;
    protected GameElement[] gameElements;
    public Troop(int count,int cost){
        this.cost = cost;
        this.count = count;
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
