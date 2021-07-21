package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.SpellElement;
import sample.model.mechanismes.Side;

public class FireBallElement extends SpellElement {

    private int areaDamage;

    public FireBallElement(Side side){
        super(side);
        areaDamage = 325;
    }

    public void setAreaDamage(int areaDamage) {
        this.areaDamage = areaDamage;
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setAreaDamage(325);
            }
            case 2 -> {
                setAreaDamage(357);
            }
            case 3 -> {
                setAreaDamage(393);
            }
            case 4 -> {
                setAreaDamage(432);
            }
            case 5 -> {
                setAreaDamage(474);
            }
        }

    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }
}
