package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class Archers extends Troop {

    public Archers(){
        super(2,3);
    }
    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
