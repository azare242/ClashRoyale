package sample.model.elements.towers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.elements.GameElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

import java.util.Iterator;

/**
 * The type Princess tower.
 */
public class PrincessTower extends TowerElement{
    /**
     * Instantiates a new Princess tower.
     *
     * @param side the side
     */
    public PrincessTower(Side side) {
        super(7.5,0.8,1400,50,side);
    }


    private double distance(ImageView thisImageView,ImageView otherImageView){
        double dx = Math.abs(otherImageView.getLayoutX() - thisImageView.getLayoutX());
        double dy = Math.abs(otherImageView.getLayoutY() - thisImageView.getLayoutY());
        return Math.hypot(dx,dy);
    }
    private GameElement canBattle(ImageView imageView, ObservableList<Node> inGameElements){
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            ImageView element = null;
            while (iterator.hasNext()){
                element = (ImageView) iterator.next();
                GameElement gameElement = (GameElement) element.getUserData();
                if (gameElement != null){
                    if (this.side != gameElement.getSide()) {
                        if (distance(imageView, element) <= range * 10) {
                            return gameElement;
                        }
                    }
                }
            }
        }
        return null;
    }
    private void damageElement(GameElement gameElement){
        gameElement.takeDamage(this.damage);
    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt) {
        animation = new Timeline(new KeyFrame(Duration.seconds(hitSpeed), actionEvent -> {
           check(imageView);
            GameElement inRange = canBattle(imageView,inGameElements);
            if (inRange != null){
                damageElement(inRange);
            }
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(50);
                setHp(1400);
            }
            case 2 -> {
                setDamage(54);
                setHp(1512);
            }
            case 3 -> {
                setDamage(58);
                setHp(1624);
            }
            case 4 -> {
                setDamage(62);
                setHp(1750);
            }
            case 5 -> {
                setDamage(69);
                setHp(1890);
            }
        }
    }
    @Override
    public MovingArea getMovingArea() {
        return MovingArea.GROUND;
    }
}
