package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class ValkyrieElement extends TroopElement {
    public ValkyrieElement(Side side) {
        super(1.5,Speed.MEDIUM,Target.GROUND,1.5,true,880,120,side);
        Animations animations = Animations.getInstance();
        this.movingArea = MovingArea.GROUND;
        this.movingArea = MovingArea.GROUND;

        if (side == Side.PLAYER){
            move1 = animations.ValkyriePlayerSideMove1;
            move2 = animations.ValkyriePlayerSideMove2;
            attack1 = animations.ValkyriePlayerSideAttack1;
            attack2 = animations.ValkyriePlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.ValkyrieBotSideMove1;
            move2 = animations.ValkyrieBotSideMove2;
            attack1 = animations.ValkyrieBotSideAttack1;
            attack2 = animations.ValkyrieBotSideAttack2;
        }
    }

    @Override
    public void levelUp() {

    }

}
