package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.WizardElement;
import sample.model.mechanismes.Side;

public class Wizard extends Troop {

    public Wizard(Side side){
        super(1,5,side);
    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new WizardElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }


    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/WizardDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/WizardDropBotSide.PNG"));
        return null;
    }
}
