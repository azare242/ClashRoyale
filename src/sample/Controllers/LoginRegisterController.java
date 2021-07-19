package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.model.SoundEffects;
import sample.model.User;
import sample.utils.FileUtils;

import java.io.File;

public class LoginRegisterController {

    @FXML private TextField enterUsername;
    @FXML private PasswordField enterPassword;
    @FXML private Button loginButton;
    @FXML private Button registerButton;
    @FXML private TextField enterRealname;
    @FXML private TextField enterUsernameNew;
    @FXML private PasswordField enterPasswordNew;
    @FXML private Label statusLoginTab;
    @FXML private Label statusRegisterTab;
    private File folder;

    public LoginRegisterController(){
        folder = new File("Users");
        if (!folder.exists()) folder.mkdirs();
    }


    @FXML public void login(ActionEvent e){
        if (folder.listFiles().length == 0) {
            SoundEffects.playErrorSound();
            statusLoginTab.setText("User Doesn't exist");
            return;
        }
        String userName = enterUsername.getText();
        String passWord = enterPassword.getText();

        User login = loginHandle(userName,passWord);

        if (login != null) {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();

            openMenu(login);
        }
        else{
            SoundEffects.playErrorSound();
            statusLoginTab.setText("Username Or Password\n is incorrect");
        }
    }

    private void openMenu(User loggedInUser){
        try {
            Stage menuStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/menuScene.fxml"));
            loader.setController(new MenuController(loggedInUser));
            Parent root = loader.load();
            menuStage.setTitle("Clash Royal");
            menuStage.setScene(new Scene(root,321,567));
            menuStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private User loginHandle(String userName,String passWord){
        File userFile = userFile(userName);
        if (userFile == null) return null;
        FileUtils fileUtil = new FileUtils();
        User u = fileUtil.openUserFile(userName);
        if (u.correctPassWord(passWord)) return u;

        return null;
    }

    private File userFile(String userName){
        for (File file : folder.listFiles()){
            if (file.getName().equals(userName + ".bin")) return file;
        }
        return null;
    }

    private boolean checkNewUsername(String userName){
        for (File file : folder.listFiles()){
            if (file.getName().equals(userName + ".bin")){
                return false;
            }
        }
        return true;
    }
    @FXML public void register(ActionEvent e){
        String userName = enterUsernameNew.getText();
        if (checkNewUsername(userName)){
            String passWord = enterPasswordNew.getText();
            String realName = enterRealname.getText();
            saveNewUser(userName,passWord,realName);
        } else {
            SoundEffects.playErrorSound();
            statusRegisterTab.setText("a User with this username exist");
        }
    }
    private void saveNewUser(String userName,String passWord,String realName){
        FileUtils fileUtil = new FileUtils();
        User user = new User(userName,passWord,realName);
        fileUtil.saveNewUser(user);
        statusRegisterTab.setText("User Created , Please log in \nwith your username and\n password");
    }
}
