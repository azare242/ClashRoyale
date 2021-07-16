package sample.model.elements.children;

import sample.model.elements.TroopElement;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ArcherElement extends TroopElement {
    public ArcherElement() {
        super(1.2, Speed.MEDIUM, Target.AIR_AND_GROUND, 5, false, 125, 33);
    }

    @Override
    public void levelUp() {

    }
}
