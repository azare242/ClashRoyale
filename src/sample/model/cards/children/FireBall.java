package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.animations.Animations;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.FireBallElement;
import sample.model.mechanismes.Side;

/**
 * The type Fire ball.
 */
public class FireBall extends Spell {

    /**
     * Instantiates a new Fire ball.
     *
     * @param side the side
     */
    public FireBall(Side side){
        super(2.5,4,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new FireBallElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }



    @Override
    public Image getDefaultImage(String side){
        return Animations.getInstance().FireBall;

    }
}
