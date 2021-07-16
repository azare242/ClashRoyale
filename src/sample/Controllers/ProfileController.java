package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.model.User;
import sample.model.cards.Card;

import java.io.IOException;

public class ProfileController {

    private User user;

    public ProfileController(User user){
        this.user = user;
    }

    @FXML private Button backButton;
    @FXML private ImageView card1;
    @FXML private ImageView card2;
    @FXML private ImageView card3;
    @FXML private ImageView card4;
    @FXML private ImageView card5;
    @FXML private ImageView card6;
    @FXML private ImageView card7;
    @FXML private ImageView card8;
    @FXML private Label levelLabel;
    @FXML private Label cupCountLabel;

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

    @FXML private void initialize(){
        if (user.battleDeckIsEmpty()) return;

        Card card_1 = user.getCardFromDeck(0);
        card1.setId(classNameToId(card_1));
        card1.setImage(getImageByCard(card_1));
        Card card_2 = user.getCardFromDeck(1);
        card2.setId(classNameToId(card_2));
        card2.setImage(getImageByCard(card_2));
        Card card_3 = user.getCardFromDeck(2);
        card3.setId(classNameToId(card_3));
        card3.setImage(getImageByCard(card_3));
        Card card_4 = user.getCardFromDeck(3);
        card4.setId(classNameToId(card_4));
        card4.setImage(getImageByCard(card_4));
        Card card_5 = user.getCardFromDeck(4);
        card5.setId(classNameToId(card_5));
        card5.setImage(getImageByCard(card_5));
        Card card_6 = user.getCardFromDeck(5);
        card6.setId(classNameToId(card_6));
        card6.setImage(getImageByCard(card_6));
        Card card_7 = user.getCardFromDeck(6);
        card7.setId(classNameToId(card_7));
        card7.setImage(getImageByCard(card_7));
        Card card_8 = user.getCardFromDeck(7);
        card8.setId(classNameToId(card_8));
        card8.setImage(getImageByCard(card_8));


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
}
