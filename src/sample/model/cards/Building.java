package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

public abstract class Building implements Card{

    protected int level;
    private int cost;
    protected GameElement[] gameElements;
    protected Side side;

    public Building(int cost, Side side){
        this.level = 1;
        this.cost = cost;
        this.side = side;
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
