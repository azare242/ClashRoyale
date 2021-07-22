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
 * Menu Scene controller.
 */
public class MenuController {

    private User user;

    /**
     * Instantiates a new Menu controller.
     *
     * @param user the user
     */
    public MenuController(User user){
        this.user = user;
        SoundEffects.playMenuSound();
    }
    @FXML private Button profileButton;

    @FXML private Button battleDeckButton;

    @FXML private Button startGameButton;

    /**
     * Switch to profile.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void switchToProfile(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/profileScene.fxml"));
        loader.setController(new ProfileController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }

    /**
     * Switch to battle deck.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void switchToBattleDeck(javafx.event.ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) battleDeckButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/battleDeckScene.fxml"));
        loader.setController(new BattleDeckController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }

    @FXML private Label status;

    /**
     * Go to game.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void goToGame(javafx.event.ActionEvent actionEvent) throws IOException {

        if (user.battleDeckIsEmpty()){
            status.setText("Please Set Your BattleDeck");
            SoundEffects.playErrorSound();
            return;
        }
        SoundEffects.stopMenuSound();
        Stage stage  = (Stage) startGameButton.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Pics/Scenes/game.fxml"));
        loader.setController(new GameController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,600,663));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }
    @FXML private Button history;

    /**
     * History.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML public void history(javafx.event.ActionEvent actionEvent) throws IOException{
        Stage stage  = (Stage) history.getScene().getWindow();
        stage.close();

        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/history/hitory.fxml"));
        loader.setController(new HistoryController(this.user));
        Parent root = loader.load();
        stage1.setScene(new Scene(root,321,567));
        stage1.setTitle("Clash Royal");
        stage1.show();
    }

    @FXML private Button logOut;

    /**
     * Log out.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML public void logOut(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage  = (Stage) logOut.getScene().getWindow();
        stage.close();

        System.exit(0);
    }
}
