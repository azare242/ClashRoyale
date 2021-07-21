package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArrowsElement;
import sample.model.mechanismes.Side;

public class Arrows extends Spell {

    public Arrows(Side side){
        super(4,3,side);

    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new ArrowsElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }


    @Override
    public Image getDefaultImage(String side){
        return new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/test.png"));
    }
}
