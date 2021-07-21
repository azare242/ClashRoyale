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
import sample.model.elements.children.GiantElement;
import sample.model.elements.towers.TowerElement;
import sample.model.mechanismes.MovingArea;
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
    protected MovingArea movingArea;
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
    public MovingArea getMovingArea() {
        return movingArea;
    }

    private boolean canWalk(ImageView thisImageView, ObservableList<Node> inGameElements, double newX , double newY){
        if (side == Side.BOT ) {
            if (newX >= 380|| newY >= 480) return false;
        } else {
            if (newX <= 10 || newY <= 10) return false;
        }
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            while (iterator.hasNext()){
                ImageView imageView = (ImageView) iterator.next();
                if (imageView != thisImageView) {
                    boolean bridgesCondition = imageView.getLayoutY() != 261 && imageView.getLayoutX() != 84 && imageView.getLayoutX() != 342;
                    boolean condition = imageView.getLayoutY() == newY && imageView.getLayoutX() == newX;
                    if (condition && !bridgesCondition) return false;
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
    private GameElement canBattle(ImageView imageView,ObservableList<Node> inGameElements){
        synchronized (inGameElements){
            Iterator<Node> iterator = inGameElements.iterator();
            ImageView element = null;
            while (iterator.hasNext()){
                element = (ImageView) iterator.next();
                GameElement gameElement = (GameElement) element.getUserData();
                if (gameElement != null){
                if (this.side != gameElement.getSide()) {
                        if (distance(imageView, element) <= range * 10) {
                            if (checkTarget(gameElement))
                                return gameElement;
                        }
                    }
                }
            }
        }
        return null;
    }
    private boolean checkTarget(GameElement gameElement){
        if (gameElement.getMovingArea() == null) return false;
        if ((this.target == Target.AIR || this.target == Target.AIR_AND_GROUND )&& gameElement.getMovingArea() == MovingArea.AIR) return true;
        if ((this.target == Target.GROUND || this.target == Target.AIR_AND_GROUND )&& gameElement.getMovingArea() == MovingArea.GROUND) return true;
        if (this instanceof GiantElement && (gameElement instanceof BuildingElement || gameElement instanceof TowerElement)) return true;
        return false;
    }
    private Timeline animation;
    @Override
    public synchronized void takeDamage(int count){
        HP -= count;
    }
    private void check(ImageView imageView , ObservableList<Node> inGameElements){
        if (HP <= 0) {
            imageView.setImage(null);
            synchronized (inGameElements) {
                inGameElements.remove(imageView);
            }
        }
    }
    private void damageElement(GameElement gameElement){
        gameElement.takeDamage(this.damage);
    }

    private ImageView getTarget(ImageView element,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        if (this.side==Side.PLAYER){
            if (element.getLayoutY()>=nearBridge.getLayoutY())
                return nearBridge;
            else {
                if (nearBridge.getLayoutX() < 150){
                    if (ptL.getImage()!=null)
                        return ptL;
                }else {
                    if (ptR.getImage()!=null)
                        return ptR;
                }
                return kt;
            }
        }else {
            if (element.getLayoutY()<=nearBridge.getLayoutY())
                return nearBridge;
            else {
                if (nearBridge.getLayoutX() < 150){
                    if (ptL.getImage()!=null)
                        return ptL;
                }else {
                    if (ptR.getImage()!=null)
                        return ptR;
                }
                return kt;
            }
        }
    }

    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        double x = imageView.getLayoutX();
        double y = imageView.getLayoutY();
        final int[] seconds = {0};
        //ImageView target = null;

        animation = new Timeline(new KeyFrame(Duration.millis(200 + (hitSpeed * 100)), actionEvent -> {
            //target = setTarget(nearBridge,PTL,PTR,KT);
            ImageView target = getTarget(imageView , nearBridge , ptL , ptR , kt);
            check(imageView,inGameElements);
            GameElement inRange = canBattle(imageView,inGameElements);
            if (inRange != null){
                damageElement(inRange);
                if (seconds[0] % 2 == 0) {
                    imageView.setImage(attack1);
                } else {
                    imageView.setImage(attack2);
                }
            }
            else {
                if (this.side == Side.PLAYER) {
                    if (x <= target.getLayoutX()) {
                        if (imageView.getLayoutX() <= target.getLayoutX()) {
                            double newX = imageView.getLayoutX() + speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= target.getLayoutY())
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    } else {
                        if (imageView.getLayoutX() >= target.getLayoutX()) {
                            double newX = imageView.getLayoutX() - speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= target.getLayoutY())
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() - speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    }
                    if (seconds[0] % 2 == 0) {
                        imageView.setImage(move1);
                    } else {
                        imageView.setImage(move2);
                    }
                } else if (this.side == Side.BOT) {
                    if (x <= target.getLayoutX()) {
                        if (imageView.getLayoutX() <= target.getLayoutX()) {
                            double newX = imageView.getLayoutX() + speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() <= target.getLayoutY() - 60)
                                    imageView.setLayoutY(newY);
                            }
                        } else {
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    } else {
                        if (imageView.getLayoutX() >= target.getLayoutX()) {
                            double newX = imageView.getLayoutX() - speed.getTilesPerSecond();
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, newX, newY)) {
                                imageView.setLayoutX(newX);
                                if (imageView.getLayoutY() >= target.getLayoutY() - 60) {
                                    imageView.setLayoutX(newY);
                                }
                            }
                        } else {
                            double newY = imageView.getLayoutY() + speed.getTilesPerSecond();
                            if (canWalk(imageView, inGameElements, imageView.getLayoutX(), newY))
                                imageView.setLayoutY(newY);
                        }
                    }
                    if (seconds[0] % 2 == 0) {
                        imageView.setImage(move1);
                    } else {
                        imageView.setImage(move2);
                    }
                }
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
