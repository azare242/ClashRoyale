package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;

public abstract class Building implements Card{

    protected int level;
    private int cost;
    protected GameElement[] gameElements;


    public Building(int cost){
        this.level = 1;
        this.cost = cost;
    }

    @Override
    public abstract GameElement[] getGameElements() ;

    @Override
    public abstract void levelUp();

    @Override
    public int getCost(){
        return cost;
    }

    @Override
    public abstract Image getDefaultImage(String side);
}
