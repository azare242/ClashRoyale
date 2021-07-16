package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BarbariansElement;

public class Barbarians extends Troop {

    public Barbarians(){
        super(4,5);
        gameElements = new GameElement[]{
                new BarbariansElement(),new BarbariansElement(),new BarbariansElement(),new BarbariansElement()
        };
    }
    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
