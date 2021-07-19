package sample.model.elements.towers;

import javafx.scene.image.ImageView;
import sample.model.elements.GameElement;

public abstract class TowerElement implements GameElement {

    private double range;
    private double hitSpeed;
    private int hp;
    private int damage;
    private int level;

    public TowerElement(double range,double hitSpeed, int hp, int damage) {
        this.range = range;
        this.hitSpeed = hitSpeed;
        this.hp = hp;
        this.damage = damage;
        this.level = 1;
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
    public abstract void moveElement(ImageView imageView);
}
