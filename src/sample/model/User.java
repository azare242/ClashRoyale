package sample.model;

import sample.model.cards.Card;
import sample.model.cards.children.*;

import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {


    private String userName;
    private String passWord;
    private String realName;
    private BattleDeck battleDeck;
    private HashMap<String,Card> cards;


    public User(String userName,String passWord,String realName){
        this.userName = userName;
        this.passWord = passWord;
        this.realName = realName;
        battleDeck = new BattleDeck();
        initCards();
    }
    private void initCards(){
        cards = new HashMap<>();
        cards.put("BARBARIAN",new Barbarians());
        cards.put("ARCHER",new Archers());
        cards.put("BABYDRAGON",new BabyDragon());
        cards.put("WIZARD",new Wizard());
        cards.put("GIANT",new Giant());
        cards.put("VALKYRIE",new Valkyrie());
        cards.put("PEKKA",new MiniPEKKA());
        cards.put("RAGE",new Rage());
        cards.put("ARROW",new Arrows());
        cards.put("FIREBALL",new FireBall());
        cards.put("INFERNO",new InfernoTower());
        cards.put("CANNON",new Cannon());
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
