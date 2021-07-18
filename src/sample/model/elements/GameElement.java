package sample.model.elements;

import java.io.Serializable;

public interface GameElement extends Serializable {

    public void levelUp();
    public void setLevel(int level);
}
