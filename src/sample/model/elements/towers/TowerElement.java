package sample.model.elements.towers;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;

/**
 * The type Tower element.
 */
public abstract class TowerElement implements GameElement {

    /**
     * The Range.
     */
    protected double range;
    /**
     * The Hit speed.
     */
    protected double hitSpeed;
    /**
     * The Hp.
     */
    protected int hp;
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
     * Instantiates a new Tower element.
     *
     * @param range    the range
     * @param hitSpeed the hit speed
     * @param hp       the hp
     * @param damage   the damage
     * @param side     the side
     */
    public TowerElement(double range,double hitSpeed, int hp, int damage,Side side) {
        this.range = range;
        this.hitSpeed = hitSpeed;
        this.hp = hp;
        this.damage = damage;
        this.level = 1;
        this.side = side;
    }

    /**
     * Sets range.
     *
     * @param range the range
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(int hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Sets hp.
     *
     * @param hp the hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public Side getSide(){
        return side;
    }
    @Override
    public abstract void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt);

    /**
     * The Animation.
     */
    protected transient Timeline animation;
    public synchronized void takeDamage(int count){
        hp -= count;
    }

    /**
     * Check.
     *
     * @param imageView the image view
     */
    public void check(ImageView imageView){
        if (hp <= 0) {
            imageView.setImage(null);
            imageView.setUserData(null);
            animation.stop();
        }

    }
    private int damageUnRage = damage;
    private double hitSpeedUnRage = hitSpeed;
    public void rage(){
        damage += 0.4 * damage;
        hitSpeed += 0.4 * hitSpeed;

    }

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    public void unRage(){
        hitSpeed = hitSpeedUnRage;
        damage = damageUnRage;
    }
    @Override
    public void endTimeLine(){

    }
}
