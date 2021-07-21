package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

import java.io.Serializable;

public interface GameElement extends Serializable {

    public void setLevel(int level);
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt);
    public Side getSide();
    public void takeDamage(int count);
    public MovingArea getMovingArea();
}
