package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

/**
 * The type Spell element.
 */
public abstract class SpellElement implements GameElement{

    /**
     * The Level.
     */
    protected int level;
    /**
     * The Side.
     */
    protected Side side;

    /**
     * Instantiates a new Spell element.
     *
     * @param side the side
     */
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
    public void rage(){

    }
    public void unRage(){

    }
    @Override
    public void endTimeLine(){

    }
}
