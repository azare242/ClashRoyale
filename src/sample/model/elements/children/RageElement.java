package sample.model.elements.children;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.elements.GameElement;
import sample.model.elements.SpellElement;
import sample.model.mechanismes.Side;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Rage element.
 */
public class RageElement extends SpellElement {

    private double duration;

    /**
     * Instantiates a new Rage element.
     *
     * @param side the side
     */
    public RageElement(Side side){
        super(side);
        duration = 6;
    }


    /**
     * Sets duration.
     *
     * @param duration the duration
     */
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

    private double distance(ImageView thisImageView,ImageView otherImageView){
        double dx = Math.abs(otherImageView.getLayoutX() - thisImageView.getLayoutX());
        double dy = Math.abs(otherImageView.getLayoutY() - thisImageView.getLayoutY());
        return Math.hypot(dx,dy);
    }
    private ArrayList<GameElement> toRage(ImageView imageView, ObservableList<Node> inGameElements){
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
    private ArrayList<GameElement> inRangeTemp;
    private Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        final double[] seconds = {0};
        animation = new Timeline(new KeyFrame(Duration.seconds(0.5) , actionEvent -> {
            if (inRangeTemp != null) {
                for (GameElement element : inRangeTemp) {
                    element.unRage();
                }
            }
            check(imageView,inGameElements,seconds[0]);
            ArrayList<GameElement> toRage = toRage(imageView,inGameElements);
            for (GameElement element : toRage){
                element.rage();
            }
            inRangeTemp = toRage;
            seconds[0] += 0.5;
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
    private void check(ImageView imageView,ObservableList<Node> inGameElement,double seconds){
        if (seconds == duration){
            imageView.setImage(null);
            synchronized (inGameElement){
                inGameElement.remove(imageView);
            }
            animation.stop();
        }
    }
}
