package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

/**
 * The type Spell.
 */
public abstract class Spell implements Card{

    private double radius;
    private int cost;
    /**
     * The Level.
     */
    protected int level;
    /**
     * The Game elements.
     */
    protected GameElement[] gameElements;
    /**
     * The Side.
     */
    protected Side side;

    /**
     * Instantiates a new Spell.
     *
     * @param radius the radius
     * @param cost   the cost
     * @param side   the side
     */
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
