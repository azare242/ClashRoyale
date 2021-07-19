package sample.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundEffects {

    private static MediaPlayer gamePlayer = new MediaPlayer(new Media(new File("src/sample/files/FXML/game.mp3").toURI().toString()));
    private static MediaPlayer menuPlayer = new MediaPlayer(new Media(new File("src/sample/files/FXML/menu.mp3").toURI().toString()));
    public static void playErrorSound(){
        new MediaPlayer(new Media(new File("src/sample/files/FXML/error.mp3").toURI().toString())).play();
    }

    public static void playGameSound(){

        gamePlayer.play();
    }


    public static void stopGameSound(){
        gamePlayer.stop();
    }

    public static void playMenuSound(){
        menuPlayer.play();
    }

    public static void stopMenuSound(){
        menuPlayer.stop();
    }
}
