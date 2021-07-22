package sample.model.bots;

import sample.model.cards.Card;


/**
 * The type Ai bot.
 */
public class AIBot extends Bot{
    @Override
    public Card play() {
        return getCardFromBattleDeck();
    }

    @Override
    public int[] getCords() {
        return new int[0];
    }

    /**
     * Instantiates a new Ai bot.
     */
    public AIBot(){
        super();
    }
}
