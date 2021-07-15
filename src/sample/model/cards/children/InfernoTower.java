package sample.model.cards.children;

import sample.model.cards.Building;
import sample.model.elements.GameElement;

public class InfernoTower extends Building {

    public InfernoTower(){
        super(5);
    }

    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
