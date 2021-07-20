package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ValkyrieElement extends TroopElement {
    public ValkyrieElement() {
        super(1.5,Speed.MEDIUM,Target.GROUND,0,true,880,120);
    }

    @Override
    public void levelUp() {

    }

}
