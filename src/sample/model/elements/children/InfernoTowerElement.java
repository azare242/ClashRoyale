package sample.model.elements.children;

import javafx.scene.image.ImageView;
import sample.model.elements.BuildingElement;
import sample.model.mechanismes.Target;

public class InfernoTowerElement extends BuildingElement {
    public InfernoTowerElement() {
        super(0.4, Target.AIR_AND_GROUND, 6, 40, 800, 20);
        minDamage = currentDamage = 20;
        maxDamage = 400;
    }

    private int minDamage;
    private int maxDamage;
    private int currentDamage;
    public void increaseDamage(){
        if (currentDamage == maxDamage) return;
        setDamage(++currentDamage);
    }
    @Override
    public void levelUp() {

    }

    @Override
    public void moveElement(ImageView imageView){

    }
}
