package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ValkyrieElement extends TroopElement {
    public ValkyrieElement(Side side) {
        super(1.5,Speed.MEDIUM,Target.GROUND,0,true,880,120,side);
    }

    @Override
    public void levelUp() {

    }

}
