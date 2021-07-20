package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ArcherElement extends TroopElement {
    public ArcherElement(Side side) {
        super(1.2, Speed.MEDIUM, Target.AIR_AND_GROUND, 5, false, 125, 33,side);
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
    public void levelUp() {

    }


}
