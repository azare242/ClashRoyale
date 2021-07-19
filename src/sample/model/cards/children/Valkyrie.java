package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.ValkyrieElement;

public class Valkyrie extends Troop {
    public Valkyrie(){
        super(1,5);
        gameElements = new GameElement[]{new ValkyrieElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new ValkyrieElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/ValkyrieDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/ValkyrieDropBotSide.PNG"));
        return null;
    }
}
