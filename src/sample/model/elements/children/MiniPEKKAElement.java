package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

/**
 * The type Mini pekka element.
 */
public class MiniPEKKAElement extends TroopElement {
    /**
     * Instantiates a new Mini pekka element.
     *
     * @param side the side
     */
    public MiniPEKKAElement(Side side) {
        super(1.8, Speed.FAST, Target.GROUND, 1.5, false, 600, 325,side);
        Animations animations = Animations.getInstance();
        this.movingArea = MovingArea.GROUND;

        if (side == Side.PLAYER){
            move1 = animations.MiniPEKKAPlayerSideMove1;
            move2 = animations.MiniPEKKAPlayerSideMove2;
            attack1 = animations.MiniPEKKAPlayerSideAttack1;
            attack2 = animations.MiniPEKKAPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.MiniPEKKABotSideMove1;
            move2 = animations.MiniPEKKABotSideMove2;
            attack1 = animations.MiniPEKKABotSideAttack1;
            attack2 = animations.MiniPEKKABotSideAttack2;
        }
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(325);
                setHP(600);
            }
            case 2 -> {
                setDamage(357);
                setHP(660);
            }
            case 3 -> {
                setDamage(393);
                setHP(726);
            }
            case 4 -> {
                setDamage(432);
                setHP(798);
            }
            case 5 -> {
                setDamage(474);
                setHP(876);
            }
        }
    }


}
