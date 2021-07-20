package sample.model.elements;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

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



    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge){
        double x = imageView.getLayoutX();
        double y = imageView.getLayoutY();
        final int[] seconds = {0};

        Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1.5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (x<= nearBridge.getLayoutX()) {
                    if (imageView.getLayoutX() <= nearBridge.getLayoutX()) {
                        imageView.setLayoutX(imageView.getLayoutX() + speed.getTilesPerSecond());
                        imageView.setLayoutY(imageView.getLayoutY() - speed.getTilesPerSecond());
                    } else {
                        imageView.setLayoutY(imageView.getLayoutY() - speed.getTilesPerSecond());
                    }
                } else {
                    if (imageView.getLayoutX() >= nearBridge.getLayoutX()){
                        imageView.setLayoutX(imageView.getLayoutX() - speed.getTilesPerSecond());
                        imageView.setLayoutY(imageView.getLayoutY() - speed.getTilesPerSecond());
                    } else {
                        imageView.setLayoutY(imageView.getLayoutY() - speed.getTilesPerSecond());
                    }
                }
                seconds[0]++;
            }
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
}
