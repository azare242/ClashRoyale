package sample.model.elements.children;

import sample.model.animations.Animations;
import sample.model.elements.TroopElement;
import sample.model.mechanismes.MovingArea;
import sample.model.mechanismes.Side;
import sample.model.mechanismes.Speed;
import sample.model.mechanismes.Target;

public class GiantElement extends TroopElement {
    public GiantElement(Side side) {
        super(1.5,Speed.SLOW,Target.BUILDINGS,1.5,false,2000,126,side);
        Animations animations = Animations.getInstance();
        this.movingArea = MovingArea.GROUND;

        if (side == Side.PLAYER){
            move1 = animations.GiantPlayerSideMove1;
            move2 = animations.GiantPlayerSideMove2;
            attack1 = animations.GiantPlayerSideAttack1;
            attack2 = animations.GiantPlayerSideAttack2;
        } else if (side == Side.BOT){
            move1 = animations.GiantBotSideMove1;
            move2 = animations.GiantBotSideMove2;
            attack1 = animations.GiantBotSideAttack1;
            attack2 = animations.GiantBotSideAttack2;
        }
    }

    @Override
    public void setLevel(int level) {
        switch (level) {
            case 1 -> {
                setDamage(126);
                setHP(2000);
            }
            case 2 -> {
                setDamage(138);
                setHP(2200);
            }
            case 3 -> {
                setDamage(152);
                setHP(2420);
            }
            case 4 -> {
                setDamage(167);
                setHP(2660);
            }
            case 5 -> {
                setDamage(183);
                setHP(2920);
            }
        }
    }
}
