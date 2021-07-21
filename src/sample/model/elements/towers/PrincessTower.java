package sample.model.elements.towers;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

public class PrincessTower extends TowerElement{
    public PrincessTower(Side side) {
        super(7.5,0.8,1400,50,side);
    }

    @Override
    public void levelUp() {

    }
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge){

    }

    @Override
    public MovingArea getMovingArea() {
        return MovingArea.GROUND;
    }
}
