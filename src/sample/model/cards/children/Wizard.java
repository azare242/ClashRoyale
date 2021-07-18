package sample.model.cards.children;

import sample.model.cards.Troop;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.WizardElement;

public class Wizard extends Troop {

    public Wizard(){
        super(1,5);
        gameElements = new GameElement[]{new WizardElement()};
    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new WizardElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }
}
