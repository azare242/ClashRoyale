package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.elements.SpellElement;

public class FireBallElement extends SpellElement {

    private int areaDamage;

    public FireBallElement(){
        super();
        areaDamage = 325;
    }
    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
