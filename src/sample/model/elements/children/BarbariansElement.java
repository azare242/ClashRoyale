package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class BarbariansElement extends TroopElement {
    public BarbariansElement(Side side) {
        super(1.5, Speed.MEDIUM, Target.AIR_AND_GROUND, 0, false,300, 75,side);
        Animations animations = Animations.getInstance();

        if (side == Side.PLAYER){
            move1 = animations.BarbarianPlayerSideMove1;
            move2 = animations.BarbarianPlayerSideMove2;
        } else if (side == Side.BOT){
            move1 = animations.BarbarianBotSideMove1;
            move2 = animations.BarbarianBotSideMove2;
        }
    }

    @Override
    public void levelUp() {

    }

}
