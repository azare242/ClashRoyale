package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.InfernoTowerElement;

public class InfernoTower extends Building {

    public InfernoTower(){
        super(5);
        gameElements = new GameElement[]{ new InfernoTowerElement()};
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new InfernoTowerElement()};
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
