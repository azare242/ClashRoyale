package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BabyDragonElement extends TroopElement {
    public BabyDragonElement() {
        super(1.8, Speed.FAST, Target.AIR_AND_GROUND, 3, true, 800, 100);
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
