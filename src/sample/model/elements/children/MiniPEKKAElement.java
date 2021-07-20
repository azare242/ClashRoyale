package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class MiniPEKKAElement extends TroopElement {
    public MiniPEKKAElement() {
        super(1.8, Speed.FAST, Target.GROUND, 0, false, 600, 325);
    }

    @Override
    public void levelUp() {

    }


}
