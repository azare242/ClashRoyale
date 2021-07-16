package sample.model.cards.children;

import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArrowsElement;

public class Arrows extends Spell {

    public Arrows(){
        super(4,3);
        gameElements = new GameElement[]{ new ArrowsElement() };
    }

    @Override
    public GameElement[] getGameElements() {
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
