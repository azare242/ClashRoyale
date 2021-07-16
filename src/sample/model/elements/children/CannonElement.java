package sample.model.elements.children;

import sample.model.elements.BuildingElement;
import sample.model.mechanismes.Target;

public class CannonElement extends BuildingElement {
    public CannonElement() {
        super(0.8, Target.GROUND, 5.5, 30, 380, 60);
    }

    @Override
    public void levelUp() {

    }
}