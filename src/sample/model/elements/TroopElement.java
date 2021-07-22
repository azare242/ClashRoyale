package sample.model.elements;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Troop element.
 */
public abstract class TroopElement implements GameElement{

    /**
     * The Hit speed.
     */
    protected double hitSpeed;
    /**
     * The Speed.
     */
    protected Speed speed;
    /**
     * The Target.
     */
    protected Target target;
    /**
     * The Range.
     */
    protected double range;
    /**
     * The Area splash.
     */
    protected boolean areaSplash;
    /**
     * The Hp.
     */
    protected int HP;
    /**
     * The Damage.
     */
    protected int damage;
    /**
     * The Level.
     */
    protected int level;
    /**
     * The Side.
     */
    protected Side side;
    /**
     * The Move 1.
     */
    protected transient Image move1;
    /**
     * The Move 2.
     */
    protected transient Image move2;
    /**
     * The Attack 1.
     */
    protected transient Image attack1;
    /**
     * The Attack 2.
     */
    protected transient Image attack2;
    /**
     * The Moving area.
     */
    protected MovingArea movingArea;

    /**
     * Instantiates a new Troop element.
     *
     * @param hitSpeed   the hit speed
     * @param speed      the speed
     * @param target     the target
     * @param range      the range
     * @param areaSplash the area splash
     * @param HP         the hp
     * @param damage     the damage
     * @param side       the side
     */
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
        damageUnRage = damage;
        speedUnRage = speed;
        hitSpeedUnRage = hitSpeed;
    }



    @Override
    public void endTimeLine(){
        this.animation.stop();
    }

    /**
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    /**
     * Sets target.
     *
     * @param target the target
     */
    public void setTarget(Target target) {
        this.target = target;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(double range) {
        this.range = range;
    }

    /**
     * Sets area splash.
     *
     * @param areaSplash the area splash
     */
    public void setAreaSplash(boolean areaSplash) {
        this.areaSplash = areaSplash;
    }

    /**
     * Sets hp.
     *
     * @param HP the hp
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
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
        if (gameElement instanceof SpellElement) return false;
        if (gameElement.getMovingArea() == null) return false;
        if ((this.target == Target.AIR || this.target == Target.AIR_AND_GROUND )&& gameElement.getMovingArea() == MovingArea.AIR) return true;
        if ((this.target == Target.GROUND || this.target == Target.AIR_AND_GROUND )&& gameElement.getMovingArea() == MovingArea.GROUND) return true;
        if (this instanceof GiantElement && (gameElement instanceof BuildingElement || gameElement instanceof TowerElement)) return true;
        return false;
    }
    private transient Timeline animation;
    @Override
    public synchronized void takeDamage(int count){
        HP -= count;
    }
    private void check(ImageView imageView , ObservableList<Node> inGameElements){
        if (HP <= 0) {
            imageView.setImage(null);
            animation.stop();
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

    private ArrayList<GameElement> areaSplash(ImageView imageView, ObservableList<Node> inGameElements){
        ArrayList<GameElement> elements = new ArrayList<>();
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
                                elements.add(gameElement);
                        }
                    }
                }
            }
        }
        return elements;
    }
    private void damageElements(ArrayList<GameElement> inRanges){
        for (GameElement gameElement : inRanges){
            gameElement.takeDamage(this.damage);
        }
    }
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){
        double x = imageView.getLayoutX();
        double y = imageView.getLayoutY();
        final int[] seconds = {0};
        animation = new Timeline(new KeyFrame(Duration.millis(200 + (hitSpeed * 10)), actionEvent -> {
            ImageView target = getTarget(imageView , nearBridge , ptL , ptR , kt);
            check(imageView,inGameElements);
            GameElement inRange = canBattle(imageView,inGameElements);
            ArrayList<GameElement> inRanges = areaSplash(imageView,inGameElements);
            if (inRange != null || inRanges.size() != 0){
                if (!areaSplash) {
                    damageElement(inRange);
                } else {
                    damageElements(inRanges);
                }
                if (seconds[0] % 2 == 0) {
                    imageView.setImage(attack1);
                } else {
                    imageView.setImage(attack2);
                }
            }
            else if (inRange == null && inRanges.size() == 0){
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

    /**
     * The Damage un rage.
     */
    protected int damageUnRage;
    /**
     * The Hit speed un rage.
     */
    protected double hitSpeedUnRage;
    /**
     * The Speed un rage.
     */
    protected Speed speedUnRage;
    public void rage(){
        damage += 0.4 * damage;
        hitSpeed += 0.4 * hitSpeed;
        switch (speed){
            case SLOW -> speed = Speed.RAGED_SLOW;
            case MEDIUM -> speed = Speed.RAGED_MEDIUM;
            case FAST -> speed = Speed.RAGED_FAST;
        }
    }
    public void unRage(){
        hitSpeed = hitSpeedUnRage;
        damage = damageUnRage;
        speed = speedUnRage;
    }
}
