package sample.model.elements;

import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

/**
 * The type Building element.
 */
public abstract class BuildingElement implements GameElement{

    /**
     * The Hit speed.
     */
    protected double hitSpeed;
    /**
     * The Target.
     */
    protected Target target;
    /**
     * The Range.
     */
    protected double range;
    /**
     * The Life time.
     */
    protected int lifeTime;
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
     * The Image.
     */
    protected transient Image image;

    /**
     * Instantiates a new Building element.
     *
     * @param hitSpeed the hit speed
     * @param target   the target
     * @param range    the range
     * @param lifeTime the life time
     * @param HP       the hp
     * @param damage   the damage
     * @param side     the side
     */
    public BuildingElement(double hitSpeed, Target target, double range, int lifeTime, int HP, int damage,Side side) {
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
        this.HP = HP;
        this.damage = damage;
        this.side = side;
        level = 1;
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
     * Sets life time.
     *
     * @param lifeTime the life time
     */
    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
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
    public Side getSide(){
        return side;
    }

    /**
     * The Animation.
     */
    protected transient Timeline animation;
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }

        public synchronized void takeDamage(int count){
        HP -= count;
    }

    /**
     * Check.
     *
     * @param imageView      the image view
     * @param inGameElements the in game elements
     * @param seconds        the seconds
     */
    protected void check(ImageView imageView , ObservableList<Node> inGameElements,int seconds){
        if (HP <= 0 || seconds == lifeTime) {
            imageView.setImage(null);
            animation.stop();
            synchronized (inGameElements) {
                inGameElements.remove(imageView);
            }
        }
    }
    @Override
    public MovingArea getMovingArea(){
        return MovingArea.GROUND;
    }
    private int damageUnRage = damage;
    private double hitSpeedUnRage = hitSpeed;
    public void rage(){
        damage += 0.4 * damage;
        hitSpeed += 0.4 * hitSpeed;

    }
    public void unRage(){
        hitSpeed = hitSpeedUnRage;
        damage = damageUnRage;

    }
    @Override
    public void endTimeLine(){
        this.animation.stop();
    }

}

