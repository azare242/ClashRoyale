package sample.model.elements.towers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.SoundEffects;
import sample.model.animations.Animations;
import sample.model.elements.GameElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;

import java.util.Iterator;

public class KingTower extends TowerElement{
    public KingTower(Side side) {
        super(7,1,2400,50,side);
        Animations animations = Animations.getInstance();
    }

    @Override
    public void levelUp() {

    }

    private boolean active = false;

    public boolean isActive() {
        return active;
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

                        }
                    }
                }
            }
        }
        return null;
    }
    private boolean damaged = false;
    public boolean isDamaged(){
        return damaged;
    }
    private void damageElement(GameElement gameElement){
        gameElement.takeDamage(this.damage);
    }

    @Override
    public void takeDamage(int count){
        hp -= count;
        damaged = true;
    }
    private Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge) {
        active = true;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Image activeImage = null;
                Animations animations = Animations.getInstance();
                if (side == Side.BOT) activeImage = animations.BotKingActive;
                else activeImage = animations.PlayerKingActive;

                imageView.setImage(activeImage);

                SoundEffects.kingActivate();
            }
        });
        animation = new Timeline(new KeyFrame(Duration.millis(800), actionEvent -> {
            check(imageView,inGameElements);
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
