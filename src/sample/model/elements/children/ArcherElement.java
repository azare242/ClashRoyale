package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

/**
 * The type Archer element.
 */
public class ArcherElement extends TroopElement {
    /**
     * Instantiates a new Archer element.
     *
     * @param side the side
     */
    public ArcherElement(Side side) {
        super(1.2, Speed.MEDIUM, Target.AIR_AND_GROUND, 5, false, 125, 33,side);
        this.movingArea = MovingArea.GROUND;
        Animations animations = Animations.getInstance();
        if (side == Side.PLAYER){
            move1 = animations.ArcherPlayerSideMove1;
            move2 = animations.ArcherPlayerSideMove2;
            attack1 = animations.ArcherPlayerSideAttack1;
            attack2 = animations.ArcherPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.ArcherBotSideMove1;
            move2 = animations.ArcherBotSideMove2;
            attack1 = animations.ArcherBotSideAttack1;
            attack2 = animations.ArcherBotSideAttack2;
        }
    }

    @Override
    public void setLevel(int level){
        switch (level){
            case 1 -> {
                setDamage(33);
                setHP(125);
            }case 2 -> {
                setDamage(44);
                setHP(127);
            }case 3 -> {
                setDamage(48);
                setHP(151);
            }case 4 -> {
                setDamage(53);
                setHP(166);
            }case 5 -> {
                setDamage(58);
                setHP(182);
            }
        }
    }


}
