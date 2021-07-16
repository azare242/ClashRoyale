package sample.model.elements;

public abstract class SpellElement implements GameElement{

    private int level;

    public SpellElement(){
        level = 1;
    }

    @Override
    public abstract void levelUp();

    public void setLevel(int level) {
        this.level = level;
    }
}
