package sample.model.elements.children;

import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BarbariansElement extends TroopElement {
    public BarbariansElement() {
        super(1.5, Speed.MEDIUM, Target.AIR_AND_GROUND, 0, false,300, 75);
    }

    @Override
    public void levelUp() {

    }
}
