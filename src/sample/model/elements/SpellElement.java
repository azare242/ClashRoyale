package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.Side;

public abstract class SpellElement implements GameElement{

    protected int level;
    protected Side side;
    public SpellElement(Side side){
        level = 1;
        this.side = side;
    }

    @Override
    public abstract void levelUp();

    @Override
    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public Side getSide(){
        return side;
    }

    @Override
    public abstract void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge);
}
