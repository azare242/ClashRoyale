package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;

public class Valkyrie extends Troop {
    public Valkyrie(){
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
