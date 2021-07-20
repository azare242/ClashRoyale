package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.BuildingElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Target;

public class CannonElement extends BuildingElement {
    public CannonElement(Side side) {
        super(0.8, Target.GROUND, 5.5, 30, 380, 60,side);
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge){

    }
}
