package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.GiantElement;
import sample.model.mechanismes.Side;

public class Giant extends Troop {

    public Giant(Side side){
        super(1,5,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new GiantElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/GiantDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/GiantDropBotSide.PNG"));
        return null;
    }
}
