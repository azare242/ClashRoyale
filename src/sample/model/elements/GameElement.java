package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

import java.io.Serializable;

/**
 * The interface Game element.
 */
public interface GameElement extends Serializable {

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level);

    /**
     * Start element action.
     *
     * @param imageView      the image view
     * @param inGameElements the in game elements
     * @param nearBridge     the near bridge
     * @param ptL            the pt l
     * @param ptR            the pt r
     * @param kt             the kt
     */
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt);

    /**
     * Gets side.
     *
     * @return the side
     */
    public Side getSide();

    /**
     * Take damage.
     *
     * @param count the count
     */
    public void takeDamage(int count);

    /**
     * Gets moving area.
     *
     * @return the moving area
     */
    public MovingArea getMovingArea();

    /**
     * Rage.
     */
    public void rage();

    /**
     * Un rage.
     */
    public void unRage();

    /**
     * End time line.
     */
    public void endTimeLine();
}
