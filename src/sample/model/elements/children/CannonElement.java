package sample.model.elements.children;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.animations.Animations;
import sample.model.elements.BuildingElement;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Target;

import java.util.Iterator;

public class CannonElement extends BuildingElement {
    public CannonElement(Side side) {
        super(0.8, Target.GROUND, 5.5, 30, 380, 60,side);
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(60);
                setHP(380);
            }
            case 2 -> {
                setDamage(66);
                setHP(418);
            }
            case 3 -> {
                setDamage(72);
                setHP(459);
            }
            case 4 -> {
                setDamage(79);
                setHP(505);
            }
            case 5 -> {
                setDamage(87);
                setHP(554);
            }
        }
    }

    private double distance(ImageView thisImageView, ImageView otherImageView){
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
    public void takeDamage(int count){
        HP -= count;

    }
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        final int[] seconds = {0};
        animation = new Timeline(new KeyFrame(Duration.seconds(hitSpeed) , actionEvent ->{
            check(imageView,inGameElements,seconds[0]);
            GameElement inRange = canBattle(imageView,inGameElements);
            if (inRange != null) {
                damageElement(inRange);
            }
            seconds[0]++;
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }


}
