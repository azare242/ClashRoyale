package sample.model.elements;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Target;

public abstract class BuildingElement implements GameElement{

    protected double hitSpeed;
    protected Target target;
    protected double range;
    protected int lifeTime;
    protected int HP;
    protected int damage;
    protected int level;
    protected Side side;
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

    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
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
    public Side getSide(){
        return side;
    }
    @Override
    public void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge , ImageView ptL , ImageView ptR , ImageView kt){

    }

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
    @Override
    public MovingArea getMovingArea(){
        return MovingArea.GROUND;
    }
}

