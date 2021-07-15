package sample.model.cards.children;


import sample.model.cards.Building;
import sample.model.elements.GameElement;

public class Cannon extends Building {

    public Cannon(){
        super(6);
    }
    @Override
    public GameElement[] getGameElements() {
        return new GameElement[0];
    }

    @Override
    public void levelUp() {

    }
}
