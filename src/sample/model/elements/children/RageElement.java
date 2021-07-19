package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.elements.SpellElement;

public class RageElement extends SpellElement {

    private double duration;
    public RageElement(){
        super();
        duration = 6;
    }
    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
