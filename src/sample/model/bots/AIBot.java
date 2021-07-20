package sample.model.bots;

import sample.model.cards.Card;


public class AIBot extends Bot{
    @Override
    public Card play() {
        return getCardFromBattleDeck();
    }

    @Override
    public int[] getCords() {
        return new int[0];
    }

    public AIBot(){
        super();
    }
}
