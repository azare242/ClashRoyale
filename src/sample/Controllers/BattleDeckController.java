package sample.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.model.BattleDeck;
import sample.model.User;
import sample.model.cards.Card;
import sample.utils.FileUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class BattleDeckController {

    private User user;
    private HashMap<Integer,String> initBattleDeckTemp;
    public BattleDeckController(User user){
        this.user = user;
        initBattleDeckTemp = new HashMap<>();
    }

    private Image getImageByCard(Card card){
        if (card == null) return null;
        String className = card.getClass().getSimpleName();
        Image image = null;
        switch (className){
            case "Archers" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArchersCard.png"));
                break;
            case "Arrows" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArrowsCard.png"));
                break;
            case "BabyDragon" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BabyDragonCard.png"));
                break;
            case "Barbarians" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BarbariansCard.png"));
                break;
            case "Cannon" :
                image =  new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/CannonCard.png"));
                break;
            case "FireBall" :
                image =  new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/FireballCard.png"));
                break;
            case "Giant" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/GiantCard.png"));
                break;
            case "InfernoTower":
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/InfernoTowerCard.png"));
                break;
            case "MiniPEKKA" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/MiniPEKKACard.png"));
                break;
            case "Rage" :
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/RageCard.png"));
                break;
            case "Valkyrie" :
                image =  new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ValkyrieCard.png"));
                break;
            case "Wizard":
                image = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/WizardCard.png"));
                break;
        }
        return image;
    }
    private String classNameToId(Card card){
        String className = card.getClass().getSimpleName();
        String id = "";
        switch (className){
            case "Archers" :
                id = "ARCHER";
                break;
            case "Arrows":
                id = "ARROW";
                break;
            case "BabyDragon":
                id = "BABYDRAGON";
                break;
            case "Barbarians":
                id = "BARBARIAN";
                break;
            case "Cannon":
                id = "CANNON";
                break;
            case "FireBall":
                id = "FIREBALL";
                break;
            case "Giant":
                id = "GIANT";
                break;
            case "InfernoTower" :
                id = "INFERNO";
                break;
            case "MiniPEKKA":
                id = "PEKKA";
                break;
            case "Rage" :
                id = "RAGE";
                break;
            case "Valkyrie" :
                id = "VALKYRIE";
                break;
            case "Wizard":
                id = "WIZARD";
                break;
        }
        return id;
    }

    @FXML
    private Button backButton;

    @FXML
    private Button barbarBtn;
    @FXML
    private Button archerBtn;
    @FXML
    private Button giantBtn;
    @FXML
    private Button wizardBtn;
    @FXML
    private Button babyBtn;
    @FXML
    private Button valkyrieBtn;
    @FXML
    private Button pekkaBtn;
    @FXML
    private Button firaBallBtn;
    @FXML
    private Button rageBtn;
    @FXML
    private Button arrowBtn;
    @FXML
    private Button cannonBtn;
    @FXML
    private Button infernoBtn;

    @FXML
    private ImageView card1;
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    @FXML
    private ImageView card4;
    @FXML
    private ImageView card5;
    @FXML
    private ImageView card6;
    @FXML
    private ImageView card7;
    @FXML
    private ImageView card8;

    @FXML
    private ImageView card11;
    @FXML
    private ImageView card22;
    @FXML
    private ImageView card33;
    @FXML
    private ImageView card44;
    @FXML
    private ImageView card55;
    @FXML
    private ImageView card66;
    @FXML
    private ImageView card77;
    @FXML
    private ImageView card88;

    @FXML
    private Button clearButton;

    @FXML private Button saveButton;

    private int chosenCards;
    @FXML public void save(javafx.event.ActionEvent actionEvent) throws IOException {
        if (chosenCards != 8) return;
        for (int i = 0 ; i < 8 ; ++i){
            String id = initBattleDeckTemp.get(i);
            user.addCardToDeck(i,id);
        }
        FileUtils fileUtils = new FileUtils();
        fileUtils.saveNewUser(this.user);
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menuScene.fxml"));
        loader.setController(new MenuController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }

    @FXML
    private void initialize(){
        ArrayList<ImageView> views = buildArray();
        if (user.battleDeckIsEmpty()) {
            for (int i = 0 ; i < 8 ; ++i){
                ImageView view = views.get(i);
                view.setId("");
                view.setImage(null);
                initBattleDeckTemp.put(i,"");

            }
            chosenCards = 0;
            return;
        }

        for (int i = 0; i < 8 ; ++i){
            ImageView view = views.get(i);
            Card card = user.getCardFromDeck(i);
            view.setId(classNameToId(card));
            Image image = getImageByCard(card);
            view.setImage(image);
            initBattleDeckTemp.put(i,classNameToId(card));
            chosenCards++;

        }
    }
    @FXML
    public void addBarbar(javafx.event.ActionEvent actionEvent){
        if (hasID("BARBARIAN")){
            removeRepetitive("BARBARIAN");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("BARBARIAN");
            Image barbar = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BarbariansCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(barbar);
                }
            });
            initBattleDeckTemp.replace(i,"BARBARIAN");
            chosenCards++;

        }
    }
    @FXML
    public void addArcher(javafx.event.ActionEvent actionEvent){
        if (hasID("ARCHER")){
            removeRepetitive("ARCHER");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("ARCHER");
            Image archer = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArchersCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(archer);
                }
            });
            initBattleDeckTemp.replace(i,"ARCHER");
            chosenCards++;

        }
    }
    @FXML
    public void addGiant(javafx.event.ActionEvent actionEvent){
        if (hasID("GIANT")){
            removeRepetitive("GIANT");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("GIANT");
            Image giant = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/GiantCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(giant);
                }
            });
            initBattleDeckTemp.replace(i,"GIANT");
            chosenCards++;

        }
    }
    @FXML
    public void addWizard(javafx.event.ActionEvent actionEvent){
        if (hasID("WIZARD")){
            removeRepetitive("WIZARD");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("WIZARD");
            Image wizard = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/WizardCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(wizard);
                }
            });
            initBattleDeckTemp.replace(i,"WIZARD");
            chosenCards++;

        }
    }
    @FXML
    public void addBaby(javafx.event.ActionEvent actionEvent){
        if (hasID("BABYDRAGON")){
            removeRepetitive("BABYDRAGON");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("BABYDRAGON");
            Image babyDragon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BabyDragonCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(babyDragon);
                }
            });
            initBattleDeckTemp.replace(i,"BABYDRAGON");
            chosenCards++;

        }
    }
    @FXML
    public void addValkyrie(javafx.event.ActionEvent actionEvent){
        if (hasID("VALKYRIE")){
            removeRepetitive("VALKYRIE");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("VALKYRIE");
            Image valkyrie = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ValkyrieCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(valkyrie);
                }
            });
            initBattleDeckTemp.replace(i,"VALKYRIE");
            chosenCards++;

        }
    }
    @FXML
    public void addPekka(javafx.event.ActionEvent actionEvent){
        if (hasID("PEKKA")){
            removeRepetitive("PEKKA");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("PEKKA");
            Image pekka = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/MiniPEKKACard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(pekka);
                }
            });
            initBattleDeckTemp.replace(i,"PEKKA");
            chosenCards++;

        }
    }
    @FXML
    public void addFireBall(javafx.event.ActionEvent actionEvent){
        if (hasID("FIREBALL")){
            removeRepetitive("FIREBALL");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("FIREBALL");
            Image fireBall = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/FireballCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(fireBall);
                }
            });
            initBattleDeckTemp.replace(i,"FIREBALL");
            chosenCards++;

        }
    }
    @FXML
    public void addRage(javafx.event.ActionEvent actionEvent){
        if (hasID("RAGE")){
            removeRepetitive("RAGE");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("RAGE");
            Image rage = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/RageCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(rage);
                }
            });
            initBattleDeckTemp.replace(i,"RAGE");
            chosenCards++;

        }
    }
    @FXML
    public void addArrow(javafx.event.ActionEvent actionEvent){
        if (hasID("ARROW")){
            removeRepetitive("ARROW");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("ARROW");
            Image arrow = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArrowsCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(arrow);
                }
            });
            initBattleDeckTemp.replace(i,"ARROW");
            chosenCards++;

        }
    }
    @FXML
    public void addCannon(javafx.event.ActionEvent actionEvent){
        if (hasID("CANNON")){
            removeRepetitive("CANNON");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("CANNON");
            Image cannon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/CannonCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(cannon);
                }
            });
            initBattleDeckTemp.replace(i,"CANNON");
            chosenCards++;

        }
    }
    @FXML
    public void addInferno(javafx.event.ActionEvent actionEvent){
        if (hasID("INFERNO")){
            removeRepetitive("INFERNO");
            return;
        }
        if (canChoose()) {
            ImageView card = getEmptyCard();
            int i = getEmptyCardIndex();
            card.setId("INFERNO");
            Image inferno = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/InfernoTowerCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(inferno);
                }
            });
            initBattleDeckTemp.replace(i,"INFERNO");
            chosenCards++;
        }
    }

    @FXML
    public boolean hasID(String id){
        ArrayList<ImageView> deck = buildArray();
        for (ImageView card : deck){
            if (card.getId().equals(id))
                return true;
        }
        return false;
    }

    @FXML
    public void removeRepetitive(String id){
        ArrayList<ImageView> deck = buildArray();
        for (ImageView card : deck){
            if (card.getId().equals(id)) {
                card.setId("");
                card.setImage(null);
                chosenCards--;
            }
        }
    }

    @FXML
    public void clearDeck(javafx.event.ActionEvent actionEvent){
        ArrayList<ImageView> deck = buildArray();
        for (ImageView card : deck){
            card.setId("");
            card.setImage(null);
            chosenCards = 0;

        }
        for (int i = 0 ; i < 8 ; ++i){
            initBattleDeckTemp.replace(i,"");
        }
    }

    private ArrayList<ImageView> buildArray() {
        ArrayList<ImageView> deck = new ArrayList<>();
        deck.add(card11);
        deck.add(card22);
        deck.add(card33);
        deck.add(card44);
        deck.add(card55);
        deck.add(card66);
        deck.add(card77);
        deck.add(card88);
        return deck;
    }

    @FXML
    public boolean canChoose(){
        ArrayList<ImageView> deck = buildArray();
        for (ImageView card : deck){
            if (card.getImage()==null)
                return true;
        }
        return false;
    }



    @FXML
    public void switchToMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menuScene.fxml"));
        loader.setController(new MenuController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("App");
        stage1.show();
    }

    @FXML
    public ImageView getEmptyCard(){
        ArrayList<ImageView> deck = buildArray();
        for (ImageView card : deck){
            if (card.getImage()==null)
                return card;
        }
        return null;
    }
    @FXML
    public int getEmptyCardIndex(){
        ArrayList<ImageView> deck = buildArray();
        int i = 0;
        for (ImageView card : deck){
            if (card.getImage()==null) {
                return i;
            }
            else
                i++;
        }
        return -1;
    }
}
