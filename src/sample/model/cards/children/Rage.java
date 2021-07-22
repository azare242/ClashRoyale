package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.animations.Animations;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.RageElement;
import sample.model.mechanismes.Side;

/**
 * The type Rage.
 */
public class Rage extends Spell {

    /**
     * Instantiates a new Rage.
     *
     * @param side the side
     */
    public Rage(Side side){
        super(5,3,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new RageElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }



    @Override
    public Image getDefaultImage(String side){
        return Animations.getInstance().RageArea;
    }
}
