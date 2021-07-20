package sample.model.cards.children;

import javafx.scene.image.Image;
import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.InfernoTowerElement;
import sample.model.mechanismes.Side;

public class InfernoTower extends Building {

    public InfernoTower(Side side){
        super(5,side);
    }

    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new InfernoTowerElement(this.side)};
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
