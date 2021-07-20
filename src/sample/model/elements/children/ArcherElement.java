package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ArcherElement extends TroopElement {
    public ArcherElement(Side side) {
        super(1.2, Speed.MEDIUM, Target.AIR_AND_GROUND, 5, false, 125, 33,side);
    }

    @Override
    public void levelUp() {

    }


}
