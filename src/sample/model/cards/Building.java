package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

/**
 * The type Building.
 */
public abstract class Building implements Card{

    /**
     * The Level.
     */
    protected int level;
    private int cost;
    /**
     * The Game elements.
     */
    protected GameElement[] gameElements;
    /**
     * The Side.
     */
    protected Side side;

    /**
     * Instantiates a new Building.
     *
     * @param cost the cost
     * @param side the side
     */
    public Building(int cost, Side side){
        this.level = 1;
        this.cost = cost;
        this.side = side;
    }

    @Override
    public abstract GameElement[] getGameElements() ;

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
