package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.RageElement;

public class Rage extends Spell {

    public Rage(){
        super(5,3);
        gameElements = new GameElement[]{new RageElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new RageElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
