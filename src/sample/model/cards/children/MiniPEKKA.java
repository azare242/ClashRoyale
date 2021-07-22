package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.MiniPEKKAElement;
import sample.model.mechanismes.Side;

/**
 * The type Mini pekka.
 */
public class MiniPEKKA extends Troop {

    /**
     * Instantiates a new Mini pekka.
     *
     * @param side the side
     */
    public MiniPEKKA(Side side){
        super(1,4,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new MiniPEKKAElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }



    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/MiniPEKKADropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/MiniPEKKADropBotSide.PNG"));
        return null;
    }
}
