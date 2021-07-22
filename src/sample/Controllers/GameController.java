package sample.Controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Controllers.view.ImagesByCard;
import sample.history.Battle;
import sample.model.ElixirHandler;
import sample.model.SoundEffects;
import sample.model.User;
import sample.model.bots.Bot;
import sample.model.bots.EasyBot;
import sample.model.cards.Card;
import sample.model.cards.Spell;
import sample.model.elements.GameElement;
import sample.model.elements.children.BabyDragonElement;
import sample.model.elements.towers.KingTower;
import sample.model.elements.towers.PrincessTower;
import sample.utils.FileUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Game Scene controller.
 */
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
    private Timeline botTimeLine;

    private ElixirHandler elixir;
    private User user;

    /**
     * The Bot.
     */
    Bot bot;

    /**
     * Instantiates a new Game controller.
     *
     * @param user the user
     */
    public GameController(User user){
        progress = 0.4;
        this.user = user;
        bot = new EasyBot();
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

    /**
     * Start timer.
     */
    @FXML
    public void startTimer(){
        timerCounter.setText("03:00");
        second = 0;
        minute = 3;
        countDownTimer();
        enemyPrincessTowerLeft.setUserData(bot.getPrincessTowerLeft());
        enemyPrincessTowerRight.setUserData(bot.getPrincessTowerRight());
        enemyKingTower.setUserData(bot.getKingTower());
        playerPrincessTowerLeft.setUserData(user.getPrincessTowerLeft());
        playerPrincessTowerRight.setUserData(user.getPrincessTowerRight());
        playerKingTower.setUserData(user.getKingTower());
        startTowers();
    }

    private void startTowers(){
        bot.getPrincessTowerLeft().startElementAction(enemyPrincessTowerLeft, mapPane.getChildren(),null,null,null,null);
        bot.getPrincessTowerRight().startElementAction(enemyPrincessTowerRight, mapPane.getChildren(),null,null,null,null);
        user.getPrincessTowerLeft().startElementAction(playerPrincessTowerLeft, mapPane.getChildren(), null,null,null,null);
        user.getPrincessTowerRight().startElementAction(playerPrincessTowerRight, mapPane.getChildren(), null,null,null,null);
    }
    @FXML private Label scoreLabelPlayer;
    @FXML private Label scoreLabelBot;
    private void addScoreToPlayer(){
            int currentScore = Integer.parseInt(scoreLabelPlayer.getText());
            scoreLabelPlayer.setText(String.valueOf(currentScore + 1));
    }
    private void addScoreToBot(){
        int currentScore = Integer.parseInt(scoreLabelBot.getText());
        scoreLabelBot.setText(String.valueOf(currentScore + 1));
    }
    private void activeKingTower(){
        KingTower kingTowerBot = bot.getKingTower();
        if (enemyPrincessTowerLeft.getImage() == null || enemyPrincessTowerRight.getImage() == null || kingTowerBot.isDamaged()){
            if (!kingTowerBot.isActive()) kingTowerBot.startElementAction(enemyKingTower,mapPane.getChildren(),null,null,null,null);
        }
        KingTower kingTowerPlayer = user.getKingTower();
        if (playerPrincessTowerLeft.getImage() == null ||playerPrincessTowerRight.getImage() == null || kingTowerPlayer.isDamaged()){
            if (!kingTowerPlayer.isActive()) kingTowerPlayer.startElementAction(playerKingTower,mapPane.getChildren(),null,null,null,null);
        }
    }
    private String checkWinner(){
        KingTower kingTowerP = (KingTower) playerKingTower.getUserData();
        KingTower kingTowerB = (KingTower) enemyKingTower.getUserData();
        PrincessTower princessTowerLP = (PrincessTower) playerPrincessTowerLeft.getUserData();
        PrincessTower princessTowerRP = (PrincessTower) playerPrincessTowerRight.getUserData();
        PrincessTower princessTowerLB = (PrincessTower) enemyPrincessTowerLeft.getUserData();
        PrincessTower princessTowerRB = (PrincessTower) enemyPrincessTowerRight.getUserData();

        if (kingTowerB.getHp() + princessTowerLB.getHp() + princessTowerRB.getHp() < kingTowerP.getHp() + princessTowerRP.getHp() + princessTowerLP.getHp()) return "PLAYER_WIN";
        else return "BOT_WIN";
    }
    private void endTimeLines(){
        synchronized (mapPane.getChildren()){
            Iterator<Node> iterator = mapPane.getChildren().iterator();
            while (iterator.hasNext()){
                ImageView imageView = (ImageView) iterator.next();
                GameElement gameElement = (GameElement) imageView.getUserData();
                if (gameElement != null) {
                    gameElement.endTimeLine();
                }
            }
        }
    }
    private void exitGame(String winner) throws IOException {
        timer.stop();
        endTimeLines();
        if (winner.equals("PLAYER_WIN")){
            user.addBattle(new Battle("YOU WIN"));
            user.addXP(200);
        } else {
            user.addBattle(new Battle("YOU LOSE"));
            user.addXP(70);
        }

        new FileUtils().saveNewUser(this.user);

        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/endGame/score.fxml"));
        loader.setController(new EndGameController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
        SoundEffects.stopGameSound();
    }
    private void checkEndGame() throws IOException {
        if (timerCounter.getText().equals("00:00")) {
            String winner = checkWinner();
            exitGame(winner);
        }

        if (enemyKingTower.getImage() == null) {
            increasePlayerScoreLabel();
            String winner = "PLAYER_WIN";
            exitGame(winner);
        }

        if (playerKingTower.getImage() == null) {
            increaseBotScoreLabel();
            String winner = "BOT_WIN";
            exitGame(winner);
        }
    }

    /**
     * Count down timer.
     */
    public void countDownTimer(){
        timer = new Timeline();
        timer.setCycleCount(Timeline.INDEFINITE);
        if (timer==null){
            timer.stop();
        }
        KeyFrame frame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scoreBoard();
                activeKingTower();
                try {
                    checkEndGame();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        botPlay();
        SoundEffects.playGameSound();
    }

    /**
     * Back to menu.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
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
        SoundEffects.stopGameSound();
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

    /**
     * Select 1.
     *
     * @param e the e
     */
    @FXML public void select1(MouseEvent e){
        playedCard = (Card) card1ImageView.getUserData();
        if (!elixir.enough(playedCard.getCost())){
            return;
        }
        setSelected(1);
        toReplaceNextTime = card1ImageView;
    }

    /**
     * Select 2.
     *
     * @param e the e
     */
    @FXML public void select2(MouseEvent e){
        playedCard = (Card) card2ImageView.getUserData();
        if (!elixir.enough(playedCard.getCost())){
            return;
        }
        setSelected(2);
        toReplaceNextTime = card2ImageView;

    }

    /**
     * Select 3.
     *
     * @param e the e
     */
    @FXML public void select3(MouseEvent e) {
    playedCard = (Card) card3ImageView.getUserData();
    if (!elixir.enough(playedCard.getCost())) {
        return;
    }
    setSelected(3);
    toReplaceNextTime = card3ImageView;

}

    /**
     * Select 4.
     *
     * @param e the e
     */
    @FXML public void select4(MouseEvent e) {
    playedCard = (Card) card4ImageView.getUserData();
    if (!elixir.enough(playedCard.getCost())) {
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
    private void setNewCost(int cost){
        if (toReplaceNextTime == card1ImageView) card1Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card2ImageView) card2Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card3ImageView) card3Cost.setText(String.valueOf(cost));
        else if (toReplaceNextTime == card4ImageView) card4Cost.setText(String.valueOf(cost));
    }


    private boolean canDeployHere(MouseEvent e){
        if (enemyPrincessTowerLeft.getImage() == null && enemyPrincessTowerRight.getImage() != null){
            return e.getX() < 226 || e.getY() > leftBridge.getLayoutY() || e.getY() > leftBridge.getLayoutY();
        }
        else if (enemyPrincessTowerRight.getImage() == null && enemyPrincessTowerLeft.getImage() != null){
            return e.getX() > 226 || e.getY() > leftBridge.getLayoutY() || e.getY() > leftBridge.getLayoutY();
        }
        else if (enemyPrincessTowerLeft.getImage() == null && enemyPrincessTowerRight.getImage() == null){
            return e.getY() < 185 || e.getY() > leftBridge.getLayoutY() || e.getY() > leftBridge.getLayoutY();
        }
        else {
            return e.getY() > leftBridge.getLayoutY() || e.getY() > rightBridge.getLayoutY();
        }
    }

    /**
     * Deploy.
     *
     * @param e the e
     */
    @FXML public void deploy(MouseEvent e){
        if (toReplaceNextTime == null) return;
        if (playedCard == null) {
            return;
        }
        if ( !canDeployHere(e) && ( !(playedCard instanceof Spell)) ){
            return;
        }
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
        progressBar.setProgress(newProgress);
        int elixirNewText = Integer.parseInt(elixirLabel.getText()) - cost;
        elixirLabel.setText(String.valueOf(elixirNewText));
        elixir.decrease(cost);
        setAllSelectedClear();
        Card tpPlay = playedCard;
        playedCard = null;
        addImageToMap(e,tpPlay);


    }
    @FXML private Pane mapPane;
    @FXML private ImageView leftBridge;
    @FXML private ImageView rightBridge;
    private void addImageToMap(MouseEvent e,Card playedCard){
        if (playedCard == null) return;
        Image image = playedCard.getDefaultImage("PLAYER");

        GameElement[] gameElements = playedCard.getGameElements();

        if (gameElements.length == 1) {
            ImageView newImageView = new ImageView(image);
            newImageView.setLayoutX(e.getX() - 50);
            newImageView.setLayoutY(e.getY() - 50);
            newImageView.setFitWidth(100);
            newImageView.setFitHeight(100);
            newImageView.setUserData(gameElements[0]);
            synchronized (mapPane.getChildren()){
                mapPane.getChildren().add(newImageView);
            }
            if (gameElements[0] instanceof BabyDragonElement){
                gameElements[0].startElementAction(newImageView,mapPane.getChildren(),nearPrincessViewForBabyDragonPlayerSide(newImageView),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            } else {
                gameElements[0].startElementAction(newImageView,mapPane.getChildren(),nearBridge(newImageView),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            }
        }
        else if (gameElements.length == 2) {
            ImageView newImageView1 = new ImageView(image);
            newImageView1.setLayoutX(e.getX() + 10 - 35);
            newImageView1.setLayoutY(e.getY() - 35);
            newImageView1.setFitWidth(70);
            newImageView1.setFitHeight(70);
            newImageView1.setUserData(gameElements[0]);
            gameElements[0].startElementAction(newImageView1,mapPane.getChildren(),nearBridge(newImageView1),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            ImageView newImageView2 = new ImageView(image);
            newImageView2.setLayoutX(e.getX() - 10 - 35);
            newImageView2.setLayoutY(e.getY() - 35);
            newImageView2.setFitWidth(70);
            newImageView2.setFitHeight(70);
            newImageView2.setUserData(gameElements[0]);
            gameElements[1].startElementAction(newImageView2,mapPane.getChildren(),nearBridge(newImageView2),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            synchronized (mapPane.getChildren()){
                mapPane.getChildren().add(newImageView1);
                mapPane.getChildren().add(newImageView2);
            }
        }
        else if (gameElements.length == 4){
            ImageView newImageView1 = new ImageView(image);
            newImageView1.setLayoutX(e.getX() + 10 - 50);
            newImageView1.setLayoutY(e.getY() - 10 - 50);
            newImageView1.setFitWidth(100);
            newImageView1.setFitHeight(100);
            newImageView1.setUserData(gameElements[0]);
            ImageView newImageView2 = new ImageView(image);
            newImageView2.setLayoutX(e.getX() - 10 - 50);
            newImageView2.setLayoutY(e.getY() - 10 - 50);
            newImageView2.setFitWidth(100);
            newImageView2.setFitHeight(100);
            newImageView2.setUserData(gameElements[1]);
            ImageView newImageView3 = new ImageView(image);
            newImageView3.setLayoutX(e.getX() - 10 - 50);
            newImageView3.setLayoutY(e.getY() + 10 - 50);
            newImageView3.setFitWidth(100);
            newImageView3.setFitHeight(100);
            newImageView3.setUserData(gameElements[2]);
            ImageView newImageView4 = new ImageView(image);
            newImageView4.setLayoutX(e.getX() + 10 - 50);
            newImageView4.setLayoutY(e.getY() + 10 - 50);
            newImageView4.setFitWidth(100);
            newImageView4.setFitHeight(100);
            newImageView4.setUserData(gameElements[3]);
            synchronized (mapPane.getChildren()){
                mapPane.getChildren().add(newImageView1);
                mapPane.getChildren().add(newImageView2);
                mapPane.getChildren().add(newImageView3);
                mapPane.getChildren().add(newImageView4);
            }
            gameElements[0].startElementAction(newImageView1,mapPane.getChildren(),nearBridge(newImageView1),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            gameElements[1].startElementAction(newImageView2,mapPane.getChildren(),nearBridge(newImageView2),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            gameElements[2].startElementAction(newImageView3,mapPane.getChildren(),nearBridge(newImageView3),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
            gameElements[3].startElementAction(newImageView4,mapPane.getChildren(),nearBridge(newImageView4),enemyPrincessTowerLeft,enemyPrincessTowerRight,enemyKingTower);
        }
    }

    private ImageView nearBridge(ImageView element){
        ImageView nearBridge = null;
        double dx1 = Math.abs(element.getLayoutX() - leftBridge.getLayoutX());
        double dx2 = Math.abs(element.getLayoutX() - rightBridge.getLayoutX());
        if (dx1>dx2) nearBridge = rightBridge;
        else nearBridge = leftBridge;

        return nearBridge;
    }

    @FXML private ImageView enemyPrincessTowerLeft;
    @FXML private ImageView enemyPrincessTowerRight;
    @FXML private ImageView enemyKingTower;
    @FXML private ImageView playerPrincessTowerLeft;
    @FXML private ImageView playerPrincessTowerRight;
    @FXML private ImageView playerKingTower;

    private ImageView nearPrincessViewForBabyDragonPlayerSide(ImageView element){
        ImageView nearPrincessTower = null;
        double dx1 = Math.abs(element.getLayoutX() - enemyPrincessTowerLeft.getLayoutX());
        double dx2 = Math.abs(element.getLayoutX() - enemyPrincessTowerRight.getLayoutX());
        if (dx1>dx2) nearPrincessTower = enemyPrincessTowerRight;
        else nearPrincessTower = enemyPrincessTowerLeft;
        return nearPrincessTower;
    }
    private ImageView nearPrincessViewForBabyDragonBotSide(ImageView element){
        ImageView nearPrincessTower = null;
        double dx1 = Math.abs(element.getLayoutX() - enemyPrincessTowerLeft.getLayoutX());
        double dx2 = Math.abs(element.getLayoutX() - enemyPrincessTowerRight.getLayoutX());
        if (dx1>dx2) nearPrincessTower =playerPrincessTowerRight;
        else nearPrincessTower = playerPrincessTowerLeft;
        return nearPrincessTower;
    }


    private void botPlay(){

        botTimeLine = new Timeline(new KeyFrame(Duration.seconds(5),actionEvent -> {
            Card card = bot.play();
            int[] cords = bot.getCords();
            Image image = card.getDefaultImage("BOT");
            GameElement[] gameElements = card.getGameElements();

            if (gameElements.length == 1){
                ImageView newImageView = new ImageView(image);
                newImageView.setLayoutX(cords[0]);
                newImageView.setLayoutY(cords[1]);
                newImageView.setFitHeight(100);
                newImageView.setFitWidth(100);
                newImageView.setUserData(gameElements[0]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView);
                }
                if (gameElements[0] instanceof BabyDragonElement){
                    gameElements[0].startElementAction(newImageView,mapPane.getChildren(),nearPrincessViewForBabyDragonBotSide(newImageView),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
                } else
                    gameElements[0].startElementAction(newImageView,mapPane.getChildren(),nearBridge(newImageView),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
            } else if (gameElements.length == 2){
                ImageView newImageView1 = new ImageView(image);
                newImageView1.setLayoutX(cords[0] + 10);
                newImageView1.setLayoutY(cords[1]);
                newImageView1.setFitWidth(70);
                newImageView1.setFitHeight(70);
                newImageView1.setUserData(gameElements[0]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView1);
                }

                gameElements[0].startElementAction(newImageView1,mapPane.getChildren(),nearBridge(newImageView1),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
                ImageView newImageView2 = new ImageView(image);
                newImageView2.setLayoutX(cords[0] - 10);
                newImageView2.setLayoutY(cords[1]);
                newImageView2.setFitWidth(70);
                newImageView2.setFitHeight(70);
                newImageView2.setUserData(gameElements[1]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView2);
                }
                gameElements[1].startElementAction(newImageView2,mapPane.getChildren(),nearBridge(newImageView2),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
            } else if (gameElements.length == 4){
                ImageView newImageView1 = new ImageView(image);
                newImageView1.setLayoutX(cords[0] + 10);
                newImageView1.setLayoutY(cords[1] - 10);
                newImageView1.setFitWidth(100);
                newImageView1.setFitHeight(100);
                newImageView1.setUserData(gameElements[0]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView1);
                }
                gameElements[0].startElementAction(newImageView1,mapPane.getChildren(),nearBridge(newImageView1),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
                ImageView newImageView2 = new ImageView(image);
                newImageView2.setLayoutX(cords[0] - 10);
                newImageView2.setLayoutY(cords[1] - 10);
                newImageView2.setFitWidth(100);
                newImageView2.setFitHeight(100);
                newImageView2.setUserData(gameElements[1]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView2);
                }
                gameElements[1].startElementAction(newImageView2,mapPane.getChildren(),nearBridge(newImageView2),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
                ImageView newImageView3 = new ImageView(image);
                newImageView3.setLayoutX(cords[0] - 10);
                newImageView3.setLayoutY(cords[1] + 10);
                newImageView3.setFitWidth(100);
                newImageView3.setFitHeight(100);
                newImageView3.setUserData(gameElements[2]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView3);
                }
                gameElements[2].startElementAction(newImageView3,mapPane.getChildren(),nearBridge(newImageView3),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
                ImageView newImageView4 = new ImageView(image);
                newImageView4.setLayoutX(cords[0] + 10);
                newImageView4.setLayoutY(cords[1] + 10);
                newImageView4.setFitWidth(100);
                newImageView4.setFitHeight(100);
                newImageView4.setUserData(gameElements[3]);
                synchronized (mapPane.getChildren()){
                    mapPane.getChildren().add(newImageView4);
                }
                gameElements[3].startElementAction(newImageView4,mapPane.getChildren(),nearBridge(newImageView4),playerPrincessTowerLeft,playerPrincessTowerRight,playerKingTower);
            }
        }));
        botTimeLine.setCycleCount(Animation.INDEFINITE);
        botTimeLine.play();
    }
    private boolean playerDBPL = false;
    private boolean playerDBPR = false;
    private boolean botDBPR = false;
    private boolean botDBPL = false;
    private void scoreBoard(){
        if (enemyPrincessTowerLeft.getImage() == null && (!playerDBPL)) {
            increasePlayerScoreLabel();
            playerDBPL = true;
        }
        if (enemyPrincessTowerRight.getImage() == null && (!playerDBPR)) {
            increasePlayerScoreLabel();
            playerDBPR = true;
        }
        if (playerPrincessTowerLeft.getImage() == null && (!botDBPL)) {
            increaseBotScoreLabel();
            botDBPL = true;
        }
        if (playerPrincessTowerRight.getImage() == null && (!botDBPR)) {
            increaseBotScoreLabel();
            botDBPR = true;
        }

    }
    private void increasePlayerScoreLabel(){
        int s = Integer.parseInt(scoreLabelPlayer.getText());
        s++;
        scoreLabelPlayer.setText(String.valueOf(s));
    }
    private void increaseBotScoreLabel(){
        int s = Integer.parseInt(scoreLabelBot.getText());
        s++;
        scoreLabelBot.setText(String.valueOf(s));
    }

}
