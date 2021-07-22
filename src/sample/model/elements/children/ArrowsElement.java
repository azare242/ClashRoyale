package sample.model.elements.children;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.SpellElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Arrows element.
 */
public class ArrowsElement extends SpellElement {

    private int areaDamage;

    /**
     * Instantiates a new Arrows element.
     *
     * @param side the side
     */
    public ArrowsElement(Side side) {
        super(side);
        areaDamage = 144;
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

    private double distance(ImageView thisImageView,ImageView otherImageView){
        double dx = Math.abs(otherImageView.getLayoutX() - thisImageView.getLayoutX());
        double dy = Math.abs(otherImageView.getLayoutY() - thisImageView.getLayoutY());
        return Math.hypot(dx,dy);
    }
    private ArrayList<GameElement> canBattle(ImageView imageView, ObservableList<Node> inGameElements){
        ArrayList<GameElement> elements = new ArrayList<>();
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            ImageView element = null;
            while (iterator.hasNext()){
                element = (ImageView) iterator.next();
                GameElement gameElement = (GameElement) element.getUserData();
                if (gameElement != null){
                    if (this.side != gameElement.getSide()) {
                        if (distance(imageView, element) <= 4 * 10) {
                            elements.add(gameElement);
                        }
                    }
                }
            }
        }
        return elements;
    }
    private transient Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        animation = new Timeline(new KeyFrame(Duration.seconds(1), actionEvent -> {
            ArrayList<GameElement> elements = canBattle(imageView,inGameElements);
            for (GameElement element : elements){
                element.takeDamage(areaDamage);
            }
            imageView.setImage(null);
            synchronized (inGameElements){
                inGameElements.remove(imageView);
            }
        }));
        animation.setCycleCount(1);
        animation.play();
    }

    /**
     * Sets area damage.
     *
     * @param areaDamage the area damage
     */
    public void setAreaDamage(int areaDamage) {
        this.areaDamage = areaDamage;
    }
}
