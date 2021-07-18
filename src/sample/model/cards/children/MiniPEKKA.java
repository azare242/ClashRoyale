package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.MiniPEKKAElement;

public class MiniPEKKA extends Troop {

    public MiniPEKKA(){
        super(1,4);
        gameElements = new GameElement[]{new MiniPEKKAElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new MiniPEKKAElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
