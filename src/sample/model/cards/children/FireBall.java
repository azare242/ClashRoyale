package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;

public class FireBall extends Spell {

    public FireBall(){
        super(2.5,4);
    }

    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
