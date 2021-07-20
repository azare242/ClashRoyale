package sample.model;

import sample.model.cards.Card;
import sample.model.cards.children.*;
import sample.model.elements.towers.KingTower;
import sample.model.elements.towers.PrincessTower;
import sample.model.mechanismes.Side;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {


    private String userName;
    private String passWord;
    private String realName;
    private BattleDeck battleDeck;
    private HashMap<String,Card> cards;
    private int XP;
    private int level;

    private PrincessTower princessTowerLeft;
    private PrincessTower princessTowerRight;
    private KingTower kingTower;

    public User(String userName,String passWord,String realName){
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
    }

    public int getXP() {
        return XP;
    }

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
    public Card getCard(String cardName){
        return cards.get(cardName);
    }
    public boolean correctPassWord(String passWord){
        return this.passWord.equals(passWord);
    }

    public String getUserName() {
        return userName;
    }

    public Card getCardFromDeck(int index){
        return battleDeck.getCard(index);
    }
    public void removeCardFromDeck(String id){
        battleDeck.removeCard(id);
    }
    public void addCardToDeck(int index,String id){
        battleDeck.setCard(index,cards.get(id));
    }
    public boolean battleDeckIsEmpty(){
        return battleDeck.deckEmptied();
    }
}
