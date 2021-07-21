package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.cards.Spell;
import sample.model.elements.SpellElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

public class ArrowsElement extends SpellElement {

    private int areaDamage;

    public ArrowsElement(Side side){
        super(side);
        areaDamage = 144;
    }
    @Override
    public void levelUp() {

    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }

}
