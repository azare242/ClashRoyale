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
    @Override
    public void levelUp() {

    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }
}
