package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArcherElement;

public class Archers extends Troop {

    public Archers(){
        super(2,3);
    }
    @Override
    public GameElement[] getGameElements() {

        gameElements = new GameElement[]{
                new ArcherElement(),new ArcherElement()
        };
        for (int i = 0 ; i < 2 ; ++i){
            gameElements[i].setLevel(level);
        }
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
