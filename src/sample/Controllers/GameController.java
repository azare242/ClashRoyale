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
import javafx.scene.input.MouseEvent;
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

        card1ImageView.setUserData(card_1);

        card2ImageView.setUserData(card_2);

        card3ImageView.setUserData(card_3);

        card4ImageView.setUserData(card_4);
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
                        if (progress == 0.9){
                            progress += 0.1;
                            elixir.increase(1);
                        }
                        if (progress == 0.8){
                            progress += 0.2;
                            elixir.increase(2);
                        }
                        if (progress == 0.7){
                            progress += 3.0;
                            elixir.increase(3);
                        }
                        else{
                            progress += 0.4;                   //4 elixir per second
                            elixir.increase(4);
                        }

                        elixirLabel.setText(String.valueOf(elixir.getCount()));
                    } else {
                        if (progress == 0.9) {
                            progress += 0.1;
                            elixir.increase(1);
                        } else {
                            progress += 0.2;                       //2 elixir per second
                            elixir.increase(2);
                        }
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


    @FXML private Label selected1;
    @FXML private Label selected2;
    @FXML private Label selected3;
    @FXML private Label selected4;

    private Card playedCard;
    private ImageView toReplaceNextTime;
    private void setSelected(int i){
        switch (i) {
            case 1 -> {
                selected1.setText("Selected");
                selected2.setText("");
                selected3.setText("");
                selected4.setText("");
            }
            case 2 -> {
                selected1.setText("");
                selected2.setText("Selected");
                selected3.setText("");
                selected4.setText("");
            }
            case 3 -> {
                selected1.setText("");
                selected2.setText("");
                selected3.setText("Selected");
                selected4.setText("");
            }
            case 4 -> {
                selected1.setText("");
                selected2.setText("");
                selected3.setText("");
                selected4.setText("Selected");
            }
        }
    }
    @FXML public void select1(MouseEvent e){
        playedCard = (Card) card1ImageView.getUserData();
        if (!elixir.enough(playedCard.getCost())){
            return;
        }
        setSelected(1);
        toReplaceNextTime = card1ImageView;
    }

@FXML public void select2(MouseEvent e){
        playedCard = (Card) card2ImageView.getUserData();
        if (!elixir.enough(playedCard.getCost())){
            return;
        }
        setSelected(2);
        toReplaceNextTime = card2ImageView;

    }

    @FXML public void select3(MouseEvent e) {
    playedCard = (Card) card3ImageView.getUserData();
    if (!elixir.enough(playedCard.getCost())) {
        return;
    }
    setSelected(3);
    toReplaceNextTime = card3ImageView;

}

@FXML public void select4(MouseEvent e){
        playedCard = (Card) card4ImageView.getUserData();
        if (!elixir.enough(playedCard.getCost())){
            return;
        }
        setSelected(4);
        toReplaceNextTime = card4ImageView;
    }


    private void setAllSelectedClear(){
        selected1.setText("");
        selected2.setText("");
        selected3.setText("");
        selected4.setText("");
    }
    private void playCard(Card card){
        cardsInGame.add(card);
    }
    @FXML public void deploy(MouseEvent e){
        if (playedCard == null) return;
        Card replaceCard = nextCard;
        playCard(playedCard);
        nextCard = getCardFromDeck();
        Image nextCardNewImage = images.getImage(nextCard);
        Image canPlayCardNewImage = images.getImage(replaceCard);
        toReplaceNextTime.setImage(canPlayCardNewImage);
        setNewCost(replaceCard.getCost());
        toReplaceNextTime.setUserData(replaceCard);
        nextCardImageView.setImage(nextCardNewImage);
        int cost = playedCard.getCost();
        double newProgress = progress - (((double) cost) / 10.0);
        progress = newProgress;
        int elixirNewText = Integer.parseInt(elixirLabel.getText()) - cost;
        elixirLabel.setText(String.valueOf(elixirNewText));
        elixir.decrease(cost);
        setAllSelectedClear();
        playedCard = null;
    }

    private void setNewCost(int cost){
        if (toReplaceNextTime == card1ImageView) card1Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card2ImageView) card2Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card3ImageView) card3Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card4ImageView) card4Cost.setText(String.valueOf(cost));
    }


}
