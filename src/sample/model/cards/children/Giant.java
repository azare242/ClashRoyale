package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.GiantElement;

public class Giant extends Troop {

    public Giant(){
        super(1,5);
        gameElements = new GameElement[]{new GiantElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new GiantElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
