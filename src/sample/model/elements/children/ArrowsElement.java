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

    public ArrowsElement(Side side) {
        super(side);
        areaDamage = 144;
    }


    @Override
    public void startElementAction(ImageView imageView, ObservableList<Node> inGameElements, ImageView nearBridge, ImageView ptL, ImageView ptR, ImageView kt) {

    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setAreaDamage(144);
            }
            case 2 -> {
                setAreaDamage(156);
            }
            case 3 -> {
                setAreaDamage(174);
            }
            case 4 -> {
                setAreaDamage(189);
            }
            case 5 -> {
                setAreaDamage(210);
            }
        }

    }

    public void setAreaDamage(int areaDamage) {
        this.areaDamage = areaDamage;
    }
}
