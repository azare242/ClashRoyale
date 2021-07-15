package sample.model;

import sample.model.cards.Card;
import sample.model.cards.children.*;

import java.io.Serializable;

public class BattleDeck implements Serializable {

    private Card[] cards;
    private boolean isEmpty;
    public BattleDeck(){
        cards = new Card[8];
        isEmpty = true;
        initEmptyDeck();
    }

    private void initEmptyDeck(){
        for (int i = 0 ; i < 8 ; ++i){
            cards[i] = null;
        }
    }

    public void setCard(int index , Card card){
        cards[index] = card;
        if (isEmpty) setIsEmpty(false);
    }

    private void setIsEmpty(boolean isEmpty){
        this.isEmpty = isEmpty;
    }

    private String idToClassName(String id){
        String className = "";
        switch (id) {
            case "BARBARIAN":
                className = Barbarians.class.getSimpleName();
                break;
            case "ARCHER":
                className = Archers.class.getSimpleName();
                break;
            case "GIANT":
                className = Giant.class.getSimpleName();
                break;
            case "WIZARD":
                className = Wizard.class.getSimpleName();
                break;
            case "BABYDRAGON":
                className = BabyDragon.class.getSimpleName();
                break;
            case "VALKYRIE":
                className = Valkyrie.class.getSimpleName();
                break;
            case "PEKKA":
                className = MiniPEKKA.class.getSimpleName();
                break;
            case "FIREBALL":
                className = FireBall.class.getSimpleName();
                break;
            case "RAGE":
                className = Rage.class.getSimpleName();
                break;
            case "ARROW":
                className = Arrows.class.getSimpleName();
                break;
            case "CANNON":
                className = Cannon.class.getSimpleName();
                break;
            case "INFERNO":
                className = InfernoTower.class.getSimpleName();
                break;
        }
        return className;
    }
    public void removeCard(String id){

        if (isEmpty) return;

        String className = idToClassName(id);
        int index = getIndexOfCard(className);
        cards[index] = null;
        if (deckEmptied()) setIsEmpty(true);
    }
    private int getIndexOfCard(String className){
        for (int i = 0 ; i < 8 ; i++) {
            if (cards[i].getClass().getSimpleName().equals(className)) return i;
        }
        return -1;
    }

    public boolean deckEmptied(){
        for (int i = 0 ; i < 8 ; ++i){
            if (cards[i] != null) return false;
        }
        return true;
    }
    public Card getCard(int index){
        return cards[index];
    }


}
