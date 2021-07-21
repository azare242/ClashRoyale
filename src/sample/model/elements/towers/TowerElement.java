package sample.model.elements.towers;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import sample.model.elements.GameElement;
import sample.model.mechanismes.Side;

public abstract class TowerElement implements GameElement {

    protected double range;
    protected double hitSpeed;
    protected int hp;
    protected int damage;
    protected int level;
    protected Side side;

    public TowerElement(double range,double hitSpeed, int hp, int damage,Side side) {
        this.range = range;
        this.hitSpeed = hitSpeed;
        this.hp = hp;
        this.damage = damage;
        this.level = 1;
        this.side = side;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setHitSpeed(int hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

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
    public abstract void startElementAction(ImageView imageView , ObservableList<Node> inGameElements,ImageView nearBridge);

    public synchronized void takeDamage(int count){
        hp -= count;
    }
    public void check(ImageView imageView , ObservableList<Node> inGameElements){
        if (hp <= 0) {
            imageView.setImage(null);
            synchronized (inGameElements) {
                inGameElements.remove(imageView);
            }
        }
    }
}
