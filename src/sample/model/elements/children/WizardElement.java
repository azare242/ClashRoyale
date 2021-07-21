package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class WizardElement extends TroopElement {
    public WizardElement(Side side) {
        super(1.7,Speed.MEDIUM,Target.AIR_AND_GROUND,5,true,340,130,side);
        Animations animations = Animations.getInstance();
        this.movingArea = MovingArea.GROUND;

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
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(130);
                setHP(340);
            }
            case 2 -> {
                setDamage(143);
                setHP(374);
            }
            case 3 -> {
                setDamage(157);
                setHP(411);
            }
            case 4 -> {
                setDamage(172);
                setHP(452);
            }
            case 5 -> {
                setDamage(189);
                setHP(496);
            }
        }
    }
}
