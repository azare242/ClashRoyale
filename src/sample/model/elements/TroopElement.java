package sample.model.elements;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

import java.util.Iterator;

public abstract class TroopElement implements GameElement{

    protected double hitSpeed;
    protected Speed speed;
    protected Target target;
    protected double range;
    protected boolean areaSplash;
    protected int HP;
    protected int damage;
    protected int level;
    protected Side side;
    protected Image move1;
    protected Image move2;
    protected Image attack1;
    protected Image attack2;
    public TroopElement(double hitSpeed, Speed speed, Target target, double range, boolean areaSplash, int HP, int damage, Side side) {
        this.hitSpeed = hitSpeed;
        this.speed = speed;
        this.target = target;
        this.range = range;
        this.areaSplash = areaSplash;
        this.HP = HP;
        this.damage = damage;
        this.side = side;
        level = 1;
    }

    @Override
    public abstract void levelUp();

    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setAreaSplash(boolean areaSplash) {
        this.areaSplash = areaSplash;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }




    private boolean canWalk(ImageView thisImageView,ObservableList<Node> inGameElements,double newX , double newY){
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            while (iterator.hasNext()){
                ImageView imageView = (ImageView) iterator.next();
                if (imageView != thisImageView) {
                    if (imageView.getLayoutY() == newY && imageView.getLayoutX() == newX) return false;
                }
            }
        }
        return true;
    }

    private double distance(ImageView thisImageView,ImageView otherImageView){
        double dx = Math.abs(otherImageView.getLayoutX() - thisImageView.getLayoutX());
        double dy = Math.abs(otherImageView.getLayoutY() - thisImageView.getLayoutY());
        return Math.hypot(dx,dy);
    }
    private boolean canBattle(ImageView imageView,ObservableList<Node> inGameElements){
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            while (iterator.hasNext()){
                ImageView element = (ImageView) iterator.next();
                GameElement gameElement = (GameElement) element.getUserData();
                if (gameElement != null){
                if (this.side != gameElement.getSide()) {
                        if (distance(imageView, element) <= range * 10) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    private Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge){
        double x = imageView.getLayoutX();
        double y = imageView.getLayoutY();
        final int[] seconds = {0};

        animation = new Timeline(new KeyFrame(Duration.millis(200), actionEvent -> {

            if (canBattle(imageView,inGameElements)){
                if (seconds[0] % 2 == 0) {
                    imageView.setImage(attack1);
                } else {
                    imageView.setImage(attack2);
                }
            }
            else {
                if (this.side == Side.PLAYER) {
                    if (x <= nearBridge.getLayoutX()) {
                        if (imageView.getLayoutX() <= nearBridge.getLayoutX()) {
                            double newX = imageView.getLayoutX() + speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= nearBridge.getLayoutY())
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    } else {
                        if (imageView.getLayoutX() >= nearBridge.getLayoutX()) {
                            double newX = imageView.getLayoutX() - speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= nearBridge.getLayoutY())
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    }
                } else if (this.side == Side.BOT) {
                    if (x <= nearBridge.getLayoutX()) {
                        if (imageView.getLayoutX() <= nearBridge.getLayoutX()) {
                            double newX = imageView.getLayoutX() + speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() <= nearBridge.getLayoutY() - 60)
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    } else {
                        if (imageView.getLayoutX() >= nearBridge.getLayoutX()) {
                            double newX = imageView.getLayoutX() - speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= nearBridge.getLayoutY() - 60) {
                                    imageView.setLayoutX(newY);
                                }
                            }
                        } else {
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    }
                }
            }

                if (seconds[0] % 2 == 0) {
                    imageView.setImage(move1);
                } else {
                    imageView.setImage(move2);
                }

            seconds[0]++;
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
    @Override
    public Side getSide(){
        return side;
    }
}
