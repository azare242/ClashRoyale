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

public class PrincessTower extends TowerElement{
    public PrincessTower(Side side) {
        super(7.5,0.8,1400,50,side);
    }

    @Override
    public void levelUp() {

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

    private Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt) {
        animation = new Timeline(new KeyFrame(Duration.millis(800), actionEvent -> {
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
    public MovingArea getMovingArea() {
        return MovingArea.GROUND;
    }
}
