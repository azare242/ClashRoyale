package sample.model.cards;

import javafx.scene.image.Image;
import sample.model.elements.GameElement;

import java.io.Serializable;

public interface Card extends Serializable {

    public GameElement[] getGameElements();
    public void levelUp();
    public int getCost();
    public Image getDefaultImage(String side);
}
