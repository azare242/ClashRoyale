package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.animations.Animations;
import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.InfernoTowerElement;
import sample.model.mechanismes.Side;

/**
 * The type Inferno tower.
 */
public class InfernoTower extends Building {

    /**
     * Instantiates a new Inferno tower.
     *
     * @param side the side
     */
    public InfernoTower(Side side){
        super(5,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new InfernoTowerElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }



    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("BOT")) return Animations.getInstance().InfernoTowerBotSide;
        else return Animations.getInstance().InfernoTowerPlayerSide;
    }
}
