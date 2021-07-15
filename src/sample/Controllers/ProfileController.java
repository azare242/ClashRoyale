package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.model.User;

import java.io.IOException;

public class ProfileController {

    private User user;

    public ProfileController(User user){
        this.user = user;
    }
    @FXML
    private Button backButton;

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
