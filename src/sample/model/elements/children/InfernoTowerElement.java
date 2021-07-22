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

/**
 * The type Inferno tower element.
 */
public class InfernoTowerElement extends BuildingElement {
    /**
     * Instantiates a new Inferno tower element.
     *
     * @param side the side
     */
    public InfernoTowerElement(Side side) {
        super(0.4, Target.AIR_AND_GROUND, 6, 40, 800, 20,side);
        minDamage = currentDamage = 20;
        maxDamage = 400;
    }

    private int minDamage;
    private int maxDamage;
    private int currentDamage;

    /**
     * Increase damage.
     */
    public void increaseDamage() {
        if (currentDamage >= maxDamage) return;
        if (currentDamage + 10 >= maxDamage) currentDamage = maxDamage;
        else currentDamage += 10;
    }

    /**
     * Reset.
     */
    public void reset(){
        currentDamage = minDamage;
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamages(20,400);
                setHP(800);
            }
            case 2 -> {
                setDamages(22,440);
                setHP(880);
            }
            case 3 -> {
                setDamages(26,532);
                setHP(968);
            }
            case 4 -> {
                setDamages(26,532);
                setHP(1064);
            }
            case 5 -> {
                setDamages(29,584);
                setHP(1168);
            }
        }
    }

    /**
     * Sets damages.
     *
     * @param minDamage the min damage
     * @param maxDamage the max damage
     */
    public void setDamages(int minDamage,int maxDamage) {
        this.currentDamage = this.minDamage = minDamage;
        this.maxDamage = maxDamage;
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
        gameElement.takeDamage(this.currentDamage);
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
            if (inRange != null){
                damageElement(inRange);
                increaseDamage();
            } else {
                reset();
            }
            seconds[0]++;
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
    }
}
