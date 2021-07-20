package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BarbariansElement;
import sample.model.mechanismes.Side;

public class Barbarians extends Troop {

    public Barbarians(Side side){
        super(4,5,side);

    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{
                new BarbariansElement(this.side),new BarbariansElement(this.side),new BarbariansElement(this.side), new BarbariansElement(this.side),
        };
        for (int i = 0 ; i < 4 ; ++i){
            gameElements[i].setLevel(level);
        }
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/BarbarianDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/BarbarianDropBotSide.PNG"));
        return null;
    }
}
