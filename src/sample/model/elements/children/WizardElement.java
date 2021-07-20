package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class WizardElement extends TroopElement {
    public WizardElement() {
        super(1.7,Speed.MEDIUM,Target.AIR_AND_GROUND,5,true,340,130);
    }

    @Override
    public void levelUp() {

    }
}
