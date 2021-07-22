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


/**
 *  History Scene controller.
 */
public class HistoryController {

    @FXML private Label history;
    private User user;
    @FXML private Button back;

    /**
     * Instantiates a new History controller.
     *
     * @param user the user
     */
    public HistoryController(User user){
        this.user = user;

    }

    /**
     * Initialize.
     */
    public void initialize(){
        history.setText(user.getBattleHistory());
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

    }
}
