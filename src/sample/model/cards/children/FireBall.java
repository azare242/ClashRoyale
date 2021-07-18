package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.FireBallElement;

public class FireBall extends Spell {

    public FireBall(){
        super(2.5,4);
        gameElements = new GameElement[]{new FireBallElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new FireBallElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
