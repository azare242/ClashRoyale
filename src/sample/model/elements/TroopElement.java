package sample.model.elements;

import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public abstract class TroopElement implements GameElement{

    private double hitSpeed;
    private Speed speed;
    private Target target;
    private double range;
    private boolean areaSplash;
    private int HP;
    private int damage;
    private int level;

    public TroopElement(double hitSpeed, Speed speed, Target target, double range, boolean areaSplash, int HP, int damage) {
        this.hitSpeed = hitSpeed;
        this.speed = speed;
        this.target = target;
        this.range = range;
        this.areaSplash = areaSplash;
        this.HP = HP;
        this.damage = damage;
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
}
