package sample.model.elements;

import sample.model.mechanismes.Target;

public abstract class BuildingElement implements GameElement{

    private double hitSpeed;
    private Target target;
    private double range;
    private int lifeTime;
    private int HP;
    private int damage;
    private int level;

    public BuildingElement(double hitSpeed, Target target, double range, int lifeTime, int HP, int damage) {
        this.hitSpeed = hitSpeed;
        this.target = target;
        this.range = range;
        this.lifeTime = lifeTime;
        this.HP = HP;
        this.damage = damage;
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

    public void setLevel(int level) {
        this.level = level;
    }
}

