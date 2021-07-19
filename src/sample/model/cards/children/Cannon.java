package sample.model.cards.children;


import javafx.scene.image.Image;
import sample.model.cards.Building;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.children.CannonElement;

public class Cannon extends Building {

    public Cannon(){
        super(6);
        gameElements = new GameElement[]{new CannonElement()};
    }
    @Override
    public GameElement[] getGameElements() {
        gameElements = new GameElement[]{new CannonElement()};
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
