package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

/**
 * The type Baby dragon element.
 */
public class BabyDragonElement extends TroopElement {
    /**
     * Instantiates a new Baby dragon element.
     *
     * @param side the side
     */
    public BabyDragonElement(Side side) {
        super(1.8, Speed.FAST, Target.AIR_AND_GROUND, 3, true, 800, 100,side);
        Animations animations = Animations.getInstance();

        this.movingArea = MovingArea.AIR;
        if (side == Side.PLAYER){
            move1 = animations.BabyDragonPlayerSideMove1;
            move2 = animations.BabyDragonPlayerSideMove2;
            attack1 = animations.BabyDragonPlayerSideAttack1;
            attack2 = animations.BabyDragonPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.BabyDragonBotSideMove1;
            move2 = animations.BabyDragonBotSideMove2;
            attack1 = animations.BabyDragonBotSideAttack1;
            attack2 = animations.BabyDragonBotSideAttack2;
        }
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(100);
                setHP(800);
            }
            case 2 -> {
                setDamage(110);
                setHP(880);
            }
            case 3 -> {
                setDamage(121);
                setHP(968);
            }
            case 4 -> {
                setDamage(133);
                setHP(1064);
            }
            case 5 -> {
                setDamage(146);
                setHP(1168);
            }
        }
    }

}
