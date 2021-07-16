package sample.model.cards.children;


import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.CannonElement;

public class Cannon extends Building {

    public Cannon(){
        super(6);
        gameElements = new GameElement[]{new CannonElement()};
    }
    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
