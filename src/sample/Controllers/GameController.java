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
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private int progress;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progressBar.setStyle("-fx-accent: #e647e9");
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

    private User user;

    public GameController(User user){
        this.user = user;
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
                if (minute<2)
                    progress+=0.4;                   //4 elixir per second
                else
                    progress+=0.2;                       //2 elixir per second
                progressBar.setProgress(progress);
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
}
