package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.model.SoundEffects;
import sample.model.User;

import java.io.IOException;

public class EndGameController {


    @FXML private Label playerScore;
    @FXML private Label botScore;
    private String  PS;
    private String BS;
    @FXML private Button back;

    private User user;
    public EndGameController(String playerScore, String botScore,User user){
        PS = playerScore;
        BS = botScore;
        this.user = user;
    }

    public void initialize(){
        playerScore.setText(PS);
        playerScore.setText(BS);
    }

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
