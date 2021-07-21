package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

public abstract class SpellElement implements GameElement{

    protected int level;
    protected Side side;
    public SpellElement(Side side){
        level = 1;
        this.side = side;
    }



    @Override
    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public Side getSide(){
        return side;
    }

    @Override
    public abstract void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt);
    public synchronized void takeDamage(int count){

    }
    private void check(ImageView imageView , ObservableList<Node> inGameElements){

    }
    @Override
    public MovingArea getMovingArea(){
        return null;
    }
}
