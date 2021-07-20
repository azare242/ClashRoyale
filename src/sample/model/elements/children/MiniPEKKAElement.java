package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class MiniPEKKAElement extends TroopElement {
    public MiniPEKKAElement(Side side) {
        super(1.8, Speed.FAST, Target.GROUND, 0, false, 600, 325,side);
        Animations animations = Animations.getInstance();

        if (side == Side.PLAYER){
            move1 = animations.MiniPEKKAPlayerSideMove1;
            move2 = animations.MiniPEKKAPlayerSideMove2;
        } else if (side == Side.BOT){
            move1 = animations.MiniPEKKABotSideMove1;
            move2 = animations.MiniPEKKABotSideMove2;
        }
    }

    @Override
    public void levelUp() {

    }


}
