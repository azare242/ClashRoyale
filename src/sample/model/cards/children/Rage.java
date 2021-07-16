package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.RageElement;

public class Rage extends Spell {

    public Rage(){
        super(5,3);
        gameElements = new GameElement[]{new RageElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
