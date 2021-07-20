package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.RageElement;
import sample.model.mechanismes.Side;

public class Rage extends Spell {

    public Rage(Side side){
        super(5,3,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new RageElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        return new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/test.png"));
    }
}
