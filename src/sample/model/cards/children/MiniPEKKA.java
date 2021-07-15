package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class MiniPEKKA extends Troop {

    public MiniPEKKA(){
        super(1,4);
    }

    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
