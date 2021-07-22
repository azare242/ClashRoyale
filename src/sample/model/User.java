package sample.model;

import sample.history.Battle;
import sample.history.BattleHistory;
import sample.model.cards.Card;
import sample.model.cards.children.*;
import sample.model.elements.towers.KingTower;
import sample.model.elements.towers.PrincessTower;
import sample.model.mechanismes.Side;

import java.io.Serializable;
import java.util.HashMap;

/**
 * The type User.
 */
public class User implements Serializable {


    private String userName;
    private String passWord;
    private String realName;
    private BattleDeck battleDeck;
    private HashMap<String,Card> cards;
    private double XP;
    private int level;

    private PrincessTower princessTowerLeft;
    private PrincessTower princessTowerRight;
    private KingTower kingTower;

    private BattleHistory battleHistory;

    /**
     * Gets princess tower left.
     *
     * @return the princess tower left
     */
    public PrincessTower getPrincessTowerLeft() {
        return princessTowerLeft;
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
     * Gets king tower.
     *
     * @return the king tower
     */
    public KingTower getKingTower() {
        return kingTower;
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param passWord the pass word
     * @param realName the real name
     */
    public User(String userName, String passWord, String realName){
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
        battleDeck = new BattleDeck();
        initCards();
        XP = 0;
        level = 1;
        princessTowerLeft = new PrincessTower(Side.PLAYER);
        princessTowerRight = new PrincessTower(Side.PLAYER);
        kingTower = new KingTower(Side.PLAYER);
        battleHistory = new BattleHistory();
    }

    /**
     * Gets xp rate.
     *
     * @return the xp rate
     */
    public double getXPRate() {
        double XPRate = 0;
        switch (level){
            case 1 -> XPRate = (XP) / 300.0;
            case 2 -> XPRate = (XP) / 500.0;
            case 3 -> XPRate = (XP) / 900.0;
            case 4 -> XPRate = (XP) / 1700.0;
            case 5 -> XPRate = (XP) / 2500.0;
        }
        return XPRate;
    }

    /**
     * Add xp.
     *
     * @param count the count
     */
    public void addXP(int count){
        XP += count;
        checkXP();
    }
    private void levelUp(){
        level++;
        XP = 0;
        for (Card card : cards.values()){
            card.levelUp();
        }
        kingTower.setLevel(level);
        princessTowerRight.setLevel(level);
        princessTowerLeft.setLevel(level);

    }
    private void checkXP(){
        switch (level){
            case 1 -> {
                if (XP >= 300) levelUp();
            }
            case 2 -> {
                if (XP >= 500) levelUp();
            }
            case 3 -> {
                if (XP >= 900) levelUp();
            }
            case 4 -> {
                if (XP >= 1700) levelUp();
            }
            case 5 -> {
                if (XP >= 2500) levelUp();
            }
        }
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    private void initCards(){
        cards = new HashMap<>();
        cards.put("BARBARIAN",new Barbarians(Side.PLAYER));
        cards.put("ARCHER",new Archers(Side.PLAYER));
        cards.put("BABYDRAGON",new BabyDragon(Side.PLAYER));
        cards.put("WIZARD",new Wizard(Side.PLAYER));
        cards.put("GIANT",new Giant(Side.PLAYER));
        cards.put("VALKYRIE",new Valkyrie(Side.PLAYER));
        cards.put("PEKKA",new MiniPEKKA(Side.PLAYER));
        cards.put("RAGE",new Rage(Side.PLAYER));
        cards.put("ARROW",new Arrows(Side.PLAYER));
        cards.put("FIREBALL",new FireBall(Side.PLAYER));
        cards.put("INFERNO",new InfernoTower(Side.PLAYER));
        cards.put("CANNON",new Cannon(Side.PLAYER));
    }

    /**
     * Get card card.
     *
     * @param cardName the card name
     * @return the card
     */
    public Card getCard(String cardName){
        return cards.get(cardName);
    }

    /**
     * Correct pass word boolean.
     *
     * @param passWord the pass word
     * @return the boolean
     */
    public boolean correctPassWord(String passWord){
        return this.passWord.equals(passWord);
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Get card from deck card.
     *
     * @param index the index
     * @return the card
     */
    public Card getCardFromDeck(int index){
        return battleDeck.getCard(index);
    }

    /**
     * Remove card from deck.
     *
     * @param id the id
     */
    public void removeCardFromDeck(String id){
        battleDeck.removeCard(id);
    }

    /**
     * Add card to deck.
     *
     * @param index the index
     * @param id    the id
     */
    public void addCardToDeck(int index,String id){
        battleDeck.setCard(index,cards.get(id));
    }

    /**
     * Battle deck is empty boolean.
     *
     * @return the boolean
     */
    public boolean battleDeckIsEmpty(){
        return battleDeck.deckEmptied();
    }

    /**
     * Add battle.
     *
     * @param battle the battle
     */
    public void addBattle(Battle battle){
        battleHistory.addBattle(battle);
    }

    /**
     * Get battle history string.
     *
     * @return the string
     */
    public String getBattleHistory(){
        return battleHistory.get();
    }
}
