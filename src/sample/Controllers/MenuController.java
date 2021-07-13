package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {


    @FXML private Button profileButton;

    @FXML private Button battleDeckButton;


    @FXML
    public void switchToProfile(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/profileScene.fxml"));
        loader.setController(new ProfileController());
        Parent root = loader.load();
        stage1.setScene(new Scene(root,364,567));
        stage1.setTitle("App");
        stage1.show();
    }

    @FXML
    public void switchToBattleDeck(javafx.event.ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) battleDeckButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/battleDeckScene.fxml"));
        loader.setController(new BattleDeckController());
        Parent root = loader.load();
        stage1.setScene(new Scene(root,364,567));
        stage1.setTitle("App");
        stage1.show();
    }


}
