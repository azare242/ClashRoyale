package sample.model.elements;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public interface GameElement extends Serializable {

    public void levelUp();
    public void setLevel(int level);
    public void moveElement(ImageView imageView);
}
