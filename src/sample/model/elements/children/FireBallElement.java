package sample.model.elements.children;

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
}
