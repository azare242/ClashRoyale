package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.FireBallElement;
import sample.model.mechanismes.Side;

public class FireBall extends Spell {

    public FireBall(Side side){
        super(2.5,4,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new FireBallElement(this.side)};
        gameElements[0].setLevel(level);
        return gameElements;
    }



    @Override
    public Image getDefaultImage(String side){
        return new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/test.png"));
    }
}
