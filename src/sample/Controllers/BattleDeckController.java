package sample.Controllers;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class BattleDeckController {

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

    @FXML
    public void addBarbar(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image barbar = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BarbariansCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(barbar);
                }
            });
        }
    }
    @FXML
    public void addArcher(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image archer = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArchersCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(archer);
                }
            });
        }
    }
    @FXML
    public void addGiant(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image giant = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/GiantCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(giant);
                }
            });
        }
    }
    @FXML
    public void addWizard(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image wizard = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/WizardCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(wizard);
                }
            });
        }
    }
    @FXML
    public void addBaby(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image babyDragon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/BabyDragonCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(babyDragon);
                }
            });
        }
    }
    @FXML
    public void addValkyrie(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image valkyrie = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ValkyrieCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(valkyrie);
                }
            });
        }
    }
    @FXML
    public void addPekka(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image pekka = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/MiniPEKKACard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(pekka);
                }
            });
        }
    }
    @FXML
    public void addFireBall(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image fireBall = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/FireballCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(fireBall);
                }
            });
        }
    }
    @FXML
    public void addRage(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image rage = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/RageCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(rage);
                }
            });
        }
    }
    @FXML
    public void addArrow(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image arrow = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/ArrowsCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(arrow);
                }
            });
        }
    }
    @FXML
    public void addCannon(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image cannon = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/CannonCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(cannon);
                }
            });
        }
    }
    @FXML
    public void addInferno(javafx.event.ActionEvent actionEvent){
        if (canChoose()) {
            ImageView card = getEmptyCard();
            Image inferno = new Image(getClass().getResourceAsStream("/sample/Controllers/view/Pics/Scenes/CardsIcon/InfernoTowerCard.png"));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    card.setImage(inferno);
                }
            });
        }
    }

    @FXML
    public void clearDeck(javafx.event.ActionEvent actionEvent){
        ArrayList<ImageView> deck = new ArrayList<>();
        deck.add(card11);
        deck.add(card22);
        deck.add(card33);
        deck.add(card44);
        deck.add(card55);
        deck.add(card66);
        deck.add(card77);
        deck.add(card88);
        for (ImageView card : deck){
            card.setImage(null);
        }
    }

    @FXML
    public boolean canChoose(){
        ArrayList<ImageView> deck = new ArrayList<>();
        deck.add(card11);
        deck.add(card22);
        deck.add(card33);
        deck.add(card44);
        deck.add(card55);
        deck.add(card66);
        deck.add(card77);
        deck.add(card88);
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
        loader.setController(new MenuController());
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("App");
        stage1.show();
    }

    @FXML
    public ImageView getEmptyCard(){
        ArrayList<ImageView> deck = new ArrayList<>();
        deck.add(card11);
        deck.add(card22);
        deck.add(card33);
        deck.add(card44);
        deck.add(card55);
        deck.add(card66);
        deck.add(card77);
        deck.add(card88);
        for (ImageView card : deck){
            if (card.getImage()==null)
                return card;
        }
        return null;
    }
}
