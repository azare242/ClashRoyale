package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;

public class BabyDragon extends Troop {

    public BabyDragon(){
        super(1,4);
        gameElements = new GameElement[]{new BabyDragonElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
