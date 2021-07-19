package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.cards.Spell;
import sample.model.elements.SpellElement;

public class ArrowsElement extends SpellElement {

    private int areaDamage;

    public ArrowsElement(){
        super();
        areaDamage = 144;
    }
    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
