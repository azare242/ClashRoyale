package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class Giant extends Troop {

    public Giant(){
        super(1,5);
    }

    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
