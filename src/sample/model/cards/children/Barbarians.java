package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BarbariansElement;

public class Barbarians extends Troop {

    public Barbarians(){
        super(4,5);

    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{
                new BarbariansElement(),new BarbariansElement(),new BarbariansElement(), new BarbariansElement(),
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
