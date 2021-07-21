package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.Side;

import java.io.Serializable;

public interface GameElement extends Serializable {

    public void levelUp();
    public void setLevel(int level);
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge);
    public Side getSide();
    public void takeDamage(int count);
}
