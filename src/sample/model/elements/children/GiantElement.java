package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.cards.Troop;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class GiantElement extends TroopElement {
    public GiantElement() {
        super(1.5,Speed.SLOW,Target.BUILDINGS,0,false,2000,126);
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
