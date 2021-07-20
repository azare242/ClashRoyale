package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class WizardElement extends TroopElement {
    public WizardElement(Side side) {
        super(1.7,Speed.MEDIUM,Target.AIR_AND_GROUND,5,true,340,130,side);
        Animations animations = Animations.getInstance();

        if (side == Side.PLAYER){
            move1 =animations.WizardPlayerSideMove1;
            move2 = animations.WizardPlayerSideMove2;
            attack1 = animations.WizardPlayerSideAttack1;
            attack2 = animations.WizardPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.WizardBotSideMove1;
            move2 = animations.WizardBotSideMove2;
            attack1 = animations.WizardBotSideAttack1;
            attack2 = animations.WizardBotSideAttack2;
        }
    }

    @Override
    public void levelUp() {

    }
}
