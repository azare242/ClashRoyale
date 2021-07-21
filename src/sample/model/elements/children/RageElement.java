package sample.model.elements.children;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.SpellElement;
import sample.model.mechanismes.Side;

public class RageElement extends SpellElement {

    private double duration;
    public RageElement(Side side){
        super(side);
        duration = 6;
    }
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDuration(6);
            }
            case 2 -> {
                setDuration(6.5);

            }
            case 3 -> {
                setDuration(7);

            }
            case 4 -> {
                setDuration(7.5);

            }
            case 5 -> {
                setDuration(8);

            }
        }
    }
}
