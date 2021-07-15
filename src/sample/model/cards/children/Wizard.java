package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class Wizard extends Troop {

    public Wizard(){
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
