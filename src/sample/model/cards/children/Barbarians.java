package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class Barbarians extends Troop {

    public Barbarians(){
        super(4,5);
    }
    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
