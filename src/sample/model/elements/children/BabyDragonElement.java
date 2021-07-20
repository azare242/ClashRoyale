package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BabyDragonElement extends TroopElement {
    public BabyDragonElement(Side side) {
        super(1.8, Speed.FAST, Target.AIR_AND_GROUND, 3, true, 800, 100,side);
        Animations animations = Animations.getInstance();

        if (side == Side.PLAYER){
            move1 = animations.BabyDragonPlayerSideMove1;
            move2 = animations.BabyDragonPlayerSideMove2;
        } else if (side == Side.BOT){
            move1 = animations.BabyDragonBotSideMove1;
            move2 = animations.BabyDragonBotSideMove2;
        }
    }

    @Override
    public void levelUp() {

    }


}
