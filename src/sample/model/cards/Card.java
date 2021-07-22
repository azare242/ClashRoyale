package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;

import java.io.Serializable;

/**
 * The interface Card.
 */
public interface Card extends Serializable {

    /**
     * Get game elements game element [ ].
     *
     * @return the game element [ ]
     */
    public GameElement[] getGameElements();

    /**
     * Level up.
     */
    public void levelUp();

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost();

    /**
     * Gets default image.
     *
     * @param side the side
     * @return the default image
     */
    public Image getDefaultImage(String side);
}
