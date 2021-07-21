package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.BuildingElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Target;

public class InfernoTowerElement extends BuildingElement {
    public InfernoTowerElement(Side side) {
        super(0.4, Target.AIR_AND_GROUND, 6, 40, 800, 20,side);
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
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamages(20,400);
                setHP(800);
            }
            case 2 -> {
                setDamages(22,440);
                setHP(880);
            }
            case 3 -> {
                setDamages(26,532);
                setHP(968);
            }
            case 4 -> {
                setDamages(26,532);
                setHP(1064);
            }
            case 5 -> {
                setDamages(29,584);
                setHP(1168);
            }
        }
    }

    public void setDamages(int minDamage,int maxDamage) {
        this.currentDamage = this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }
}
