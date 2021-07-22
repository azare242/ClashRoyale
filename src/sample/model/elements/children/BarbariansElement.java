package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

/**
 * The type Barbarians element.
 */
public class BarbariansElement extends TroopElement {
    /**
     * Instantiates a new Barbarians element.
     *
     * @param side the side
     */
    public BarbariansElement(Side side) {
        super(1.5, Speed.MEDIUM, Target.AIR_AND_GROUND, 1.5, false,300, 75,side);
        Animations animations = Animations.getInstance();
        this.movingArea = MovingArea.GROUND;

        if (side == Side.PLAYER){
            move1 = animations.BarbarianPlayerSideMove1;
            move2 = animations.BarbarianPlayerSideMove2;
            attack1 = animations.BarbarianPlayerSideAttack1;
            attack2 = animations.BarbarianPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.BarbarianBotSideMove1;
            move2 = animations.BarbarianBotSideMove2;
            attack1 = animations.BarbarianBotSideAttack1;
            attack2 = animations.BarbarianBotSideAttack2;
        }
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(75);
                setHP(300);
            }
            case 2 -> {
                setDamage(82);
                setHP(330);
            }
            case 3 -> {
                setDamage(90);
                setHP(363);
            }
            case 4 -> {
                setDamage(99);
                setHP(738);
            }
            case 5 -> {
                setDamage(109);
                setHP(480);
            }
        }
    }

}
