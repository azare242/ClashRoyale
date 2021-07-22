package sample.model.bots;

import sample.model.BattleDeck;
import sample.model.cards.Card;
import sample.model.cards.children.*;
import sample.model.elements.towers.KingTower;
import sample.model.elements.towers.PrincessTower;
import sample.model.mechanismes.Side;

import java.util.Random;

/**
 * The type Bot.
 */
public abstract class Bot {

    /**
     * The Battle deck.
     */
    protected BattleDeck battleDeck;

    /**
     * The King tower.
     */
    protected KingTower kingTower;
    /**
     * The Princess tower right.
     */
    protected PrincessTower princessTowerRight;
    /**
     * The Princess tower left.
     */
    protected PrincessTower princessTowerLeft;

    /**
     * Gets king tower.
     *
     * @return the king tower
     */
    public KingTower getKingTower() {
        return kingTower;
    }

    /**
     * Gets princess tower right.
     *
     * @return the princess tower right
     */
    public PrincessTower getPrincessTowerRight() {
        return princessTowerRight;
    }

    /**
     * Gets princess tower left.
     *
     * @return the princess tower left
     */
    public PrincessTower getPrincessTowerLeft() {
        return princessTowerLeft;
    }

    /**
     * Instantiates a new Bot.
     */
    public Bot(){
        battleDeck = new BattleDeck();
        initDeck();
        kingTower = new KingTower(Side.BOT);
        princessTowerRight = new PrincessTower(Side.BOT);
        princessTowerLeft = new PrincessTower(Side.BOT);
    }
    private void initDeck(){
        battleDeck.setCard(0,new Archers(Side.BOT));
        battleDeck.setCard(1,new Barbarians(Side.BOT));
        battleDeck.setCard(2,new BabyDragon(Side.BOT));
        battleDeck.setCard(3,new Giant(Side.BOT));
        battleDeck.setCard(4,new Valkyrie(Side.BOT));
        battleDeck.setCard(5,new Wizard(Side.BOT));
        battleDeck.setCard(6,new MiniPEKKA(Side.BOT));
        battleDeck.setCard(7,new MiniPEKKA(Side.BOT));
    }
    private int battleDeckCounter = 0;

    /**
     * Get card from battle deck card.
     *
     * @return the card
     */
    protected Card getCardFromBattleDeck(){
        int toDeploy = battleDeckCounter;
        if (battleDeckCounter == 7) battleDeckCounter = 0;
        else battleDeckCounter++;
        return battleDeck.getCard(toDeploy);
    }

    /**
     * Play card.
     *
     * @return the card
     */
    public abstract Card play();

    /**
     * Get cords int [ ].
     *
     * @return the int [ ]
     */
    public abstract int[] getCords();
}
