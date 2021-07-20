package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArrowsElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.mechanismes.Side;

public class BabyDragon extends Troop {

    public BabyDragon(Side side){
        super(1,4,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new BabyDragonElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }


    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/BabyDragonDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/BabyDragonDropBotSide.PNG"));
        return null;
    }
}
