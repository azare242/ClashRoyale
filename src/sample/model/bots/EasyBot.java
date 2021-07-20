package sample.model.bots;

import sample.model.cards.Card;

import java.util.Timer;
import java.util.TimerTask;

public class EasyBot extends Bot{
    @Override
    public Card play() {
        return getCardFromBattleDeck();
    }

    @Override
    public int[] getCords() {
        int[] res = new int[2];
        res[0] = (int) (Math.random() * (318 - 155)) + 155;
        res[1] = (int) (Math.random() * (223 - 107)) + 107;
        return res;
    }

    public EasyBot(){
        super();
    }
}
