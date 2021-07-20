package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class SpellElement implements GameElement{

    private int level;

    public SpellElement(){
        level = 1;
    }

    @Override
    public abstract void levelUp();

    @Override
    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public abstract void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge);
}
