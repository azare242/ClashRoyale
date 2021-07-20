package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BarbariansElement extends TroopElement {
    public BarbariansElement(Side side) {
        super(1.5, Speed.MEDIUM, Target.AIR_AND_GROUND, 0, false,300, 75,side);
    }

    @Override
    public void levelUp() {

    }

}
