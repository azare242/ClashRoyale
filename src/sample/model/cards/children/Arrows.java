package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.ArrowsElement;

public class Arrows extends Spell {

    public Arrows(){
        super(4,3);

    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new ArrowsElement()};
        gameElements[0].setLevel(level);
        return gameElements;
    }

    @Override
    public void levelUp() {

    }

    @Override
    public Image getDefaultImage(String side){
        return new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/test.png"));
    }
}
