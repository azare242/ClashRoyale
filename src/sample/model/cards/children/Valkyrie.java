package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.ValkyrieElement;

public class Valkyrie extends Troop {
    public Valkyrie(){
        super(1,5);
        gameElements = new GameElement[]{new ValkyrieElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
