package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

/**
 * The type Troop.
 */
public abstract class Troop implements Card{

    /**
     * The Level.
     */
    protected int level;
    private int count;
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
     * Instantiates a new Troop.
     *
     * @param count the count
     * @param cost  the cost
     * @param side  the side
     */
    public Troop(int count, int cost, Side side){
        this.cost = cost;
        this.count = count;
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
