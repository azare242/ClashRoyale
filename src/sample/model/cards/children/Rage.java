package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;

public class Rage extends Spell {

    public Rage(){
        super(5,3);
    }
    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
