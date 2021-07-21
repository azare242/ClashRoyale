package sample.model.bots;

import sample.model.BattleDeck;
import sample.model.cards.Card;
import sample.model.cards.children.*;
import sample.model.elements.towers.KingTower;
import sample.model.elements.towers.PrincessTower;
import sample.model.mechanismes.Side;

import java.util.Random;

public abstract class Bot {

    protected BattleDeck battleDeck;

    protected KingTower kingTower;
    protected PrincessTower princessTowerRight;
    protected PrincessTower princessTowerLeft;

    public KingTower getKingTower() {
        return kingTower;
    }

    public PrincessTower getPrincessTowerRight() {
        return princessTowerRight;
    }

    public PrincessTower getPrincessTowerLeft() {
        return princessTowerLeft;
    }

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
    protected Card getCardFromBattleDeck(){
        int toDeploy = battleDeckCounter;
        if (battleDeckCounter == 7) battleDeckCounter = 0;
        else battleDeckCounter++;
        return battleDeck.getCard(toDeploy);
    }

    public abstract Card play();
    public abstract int[] getCords();
}
