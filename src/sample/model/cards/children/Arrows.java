package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.animations.Animations;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArrowsElement;
import sample.model.mechanismes.Side;

/**
 * The type Arrows.
 */
public class Arrows extends Spell {

    /**
     * Instantiates a new Arrows.
     *
     * @param side the side
     */
    public Arrows(Side side){
        super(4,3,side);

    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new ArrowsElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }


    @Override
    public Image getDefaultImage(String side){
        return Animations.getInstance().Arrows;
    }
}
