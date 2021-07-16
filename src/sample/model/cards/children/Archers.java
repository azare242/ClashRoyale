package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArcherElement;

public class Archers extends Troop {

    public Archers(){
        super(2,3);
        gameElements = new GameElement[]{
                new ArcherElement() , new ArcherElement()
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
