package sample.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Controllers.view.ImagesByCard;
import sample.model.ElixirHandler;
import sample.model.User;
import sample.model.cards.Card;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private double progress;
    @FXML private Label elixirLabel;
    private List<Card> cardsInGame;
    private ImagesByCard images;

    private Card nextCard;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setStyle("-fx-accent: #e647e9");

        setPlayerDeckOnViews();
    }

    private Card getCardFromDeck(){
        Card card = cardsInGame.get(0);
        cardsInGame.remove(0);
        return card;
    }
    private void setPlayerDeckOnViews(){
        Card card_1 = getCardFromDeck();
        Image image_1 = images.getImage(card_1);
        card1ImageView.setImage(image_1);
        card1Cost.setText(String.valueOf(card_1.getCost()));
        Card card_2 = getCardFromDeck();
        Image image_2 = images.getImage(card_2);
        card2ImageView.setImage(image_2);
        card2Cost.setText(String.valueOf(card_2.getCost()));
        Card card_3 = getCardFromDeck();
        Image image_3 = images.getImage(card_3);
        card3ImageView.setImage(image_3);
        card3Cost.setText(String.valueOf(card_3.getCost()));
        Card card_4 = getCardFromDeck();
        Image image_4 = images.getImage(card_4);
        card4ImageView.setImage(image_4);
        card4Cost.setText(String.valueOf(card_4.getCost()));
        nextCard = getCardFromDeck();
        Image image_next = images.getImage(nextCard);
        nextCardImageView.setImage(image_next);
    }
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button startBtn;

    @FXML
    private Label timerCounter;

    @FXML
    private Button back;

    private Timeline timer;
    private int second , minute;

    private ElixirHandler elixir;
    private User user;

    public GameController(User user){
        progress = 0.4;
        this.user = user;
        elixir = new ElixirHandler();
        initCardsInGame();
        images = ImagesByCard.getInstance();
    }
    private void initCardsInGame(){
        cardsInGame = new ArrayList<>();
        for (int i = 0 ; i < 8 ; ++i){
            cardsInGame.add(user.getCardFromDeck(i));
        }
        Collections.shuffle(cardsInGame);
    }
    @FXML
    public void startTimer(){
        timerCounter.setText("03:00");
        second = 0;
        minute = 3;
        countDownTimer();
    }

    public void countDownTimer(){
        timer = new Timeline();
        timer.setCycleCount(Timeline.INDEFINITE);
        if (timer==null){
            timer.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                second--;
                if (!elixir.isFull()) {
                    if (minute < 2) {
                        progress += 0.4;                   //4 elixir per second
                        elixir.increase(4);
                        elixirLabel.setText(String.valueOf(elixir.getCount()));
                    } else {
                        progress += 0.2;                       //2 elixir per second
                        elixir.increase(2);
                        elixirLabel.setText(String.valueOf(elixir.getCount()));
                    }
                    progressBar.setProgress(progress);
                }
                if (second<10){
                    timerCounter.setText("0"+minute + ":" +"0"+second);
                }else {
                    timerCounter.setText("0"+minute + ":" +second);
                }
                if (second==-1){
                    second  = 59;
                    minute--;
                    timerCounter.setText("0"+minute + ":" +second);
                }
                if (minute==0 && second == 0){
                    timer.stop();
                }
            }
        });
        timer.getKeyFrames().add(frame);
        timer.playFromStart();
    }

    @FXML
    public void backToMenu(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menuScene.fxml"));
        loader.setController(new MenuController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }


    @FXML private Label card1Cost;
    @FXML private Label card2Cost;
    @FXML private Label card3Cost;
    @FXML private Label card4Cost;

    @FXML private ImageView card1ImageView;
    @FXML private ImageView card2ImageView;
    @FXML private ImageView card3ImageView;
    @FXML private ImageView card4ImageView;
    @FXML private ImageView nextCardImageView;



}
