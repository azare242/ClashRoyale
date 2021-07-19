package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.MiniPEKKAElement;

public class MiniPEKKA extends Troop {

    public MiniPEKKA(){
        super(1,4);
        gameElements = new GameElement[]{new MiniPEKKAElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new MiniPEKKAElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/MiniPEKKADropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/MiniPEKKADropBotSide.PNG"));
        return null;
    }
}
