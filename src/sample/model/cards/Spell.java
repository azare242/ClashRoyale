package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

public abstract class Spell implements Card{

    private double radius;
    private int cost;
    protected int level;
    protected GameElement[] gameElements;
    protected Side side;

    public Spell(double radius, int cost, Side side){
        this.radius = radius;
        this.cost = cost;
        this.level = 1;
        this.side = side;
    }
    @Override
    public abstract GameElement[] getGameElements();

    public void levelUp() {
        level++;
    }

    @Override
    public int getCost(){
        return cost;
    }

    @Override
    public abstract Image getDefaultImage(String side);


}
