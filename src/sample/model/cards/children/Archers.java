package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArcherElement;
import sample.model.mechanismes.Side;

public class Archers extends Troop {

    public Archers(Side side){
        super(2,3,side);
    }
    @Override
    public GameElement[] getGameElements() {

        gameElements = new GameElement[]{
                new ArcherElement(this.side),new ArcherElement(this.side)
        };
        for (int i = 0 ; i < 2 ; ++i){
            gameElements[i].setLevel(level);
        }
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        if (side.equalsIgnoreCase("PLAYER")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/ArcherDropPlayerSide.PNG"));
        else if (side.equalsIgnoreCase("BOT")) return new Image(getClass().getResourceAsStream("/sample/model/cards/children/images/drop/ArcherDropBotSide.PNG"));
        return null;
    }
}
