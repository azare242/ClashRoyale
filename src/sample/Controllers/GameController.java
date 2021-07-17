package sample.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class GameController {

    @FXML
    private Button startBtn;

    @FXML
    private Label timerCounter;

    private Timeline timer;
    private int second , minute;

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
}
