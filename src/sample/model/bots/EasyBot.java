package sample.model.bots;

import sample.model.cards.Card;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The type Easy bot.
 */
public class EasyBot extends Bot{
    @Override
    public Card play() {
        return getCardFromBattleDeck();
    }

    private Random r = new Random();
    @Override
    public int[] getCords() {
        int random = r.nextInt();
        int[] res = new int[2];
        if (random % 2 == 0 ) res[0] = 80;
        else if (random % 2 == 1) res[0] = 340;
        res[1] = 140;
        return res;
    }

    /**
     * Instantiates a new Easy bot.
     */
    public EasyBot(){
        super();
    }
}
