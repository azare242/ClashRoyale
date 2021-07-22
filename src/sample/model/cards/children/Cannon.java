package sample.model.cards.children;


import javafx.scene.image.Image;
import sample.model.animations.Animations;
import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.CannonElement;
import sample.model.mechanismes.Side;

/**
 * The type Cannon.
 */
public class Cannon extends Building {

    /**
     * Instantiates a new Cannon.
     *
     * @param side the side
     */
    public Cannon(Side side){
        super(6,side);
    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new CannonElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }


    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("BOT")) return Animations.getInstance().CannonBotSide;
        else return Animations.getInstance().CannonPlayerSide;
    }
}
