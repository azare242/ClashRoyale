package sample.model.elements.towers;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.Side;

public class KingTower extends TowerElement{
    public KingTower(Side side) {
        super(7,1,2400,50,side);
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge){

    }
}
