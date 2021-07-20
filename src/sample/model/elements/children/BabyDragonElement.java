package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BabyDragonElement extends TroopElement {
    public BabyDragonElement(Side side) {
        super(1.8, Speed.FAST, Target.AIR_AND_GROUND, 3, true, 800, 100,side);
    }

    @Override
    public void levelUp() {

    }


}
