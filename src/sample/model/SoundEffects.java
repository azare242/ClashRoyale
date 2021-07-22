package sample.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/**
 * The type Sound effects.
 */
public class SoundEffects {

    private static MediaPlayer gamePlayer = new MediaPlayer(new Media(new File("src/sample/files/FXML/game.mp3").toURI().toString()));
    private static MediaPlayer menuPlayer = new MediaPlayer(new Media(new File("src/sample/files/FXML/menu.mp3").toURI().toString()));
    private static MediaPlayer kingActivate = new MediaPlayer(new Media(new File("src/sample/files/FXML/king_activate.mp3").toURI().toString()));

    /**
     * Play error sound.
     */
    public static void playErrorSound(){
        new MediaPlayer(new Media(new File("src/sample/files/FXML/error.mp3").toURI().toString())).play();
    }

    /**
     * Play game sound.
     */
    public static void playGameSound(){

        gamePlayer.play();
    }

    /**
     * King activate.
     */
    public static void kingActivate(){
        kingActivate.play();
    }


    /**
     * Stop game sound.
     */
    public static void stopGameSound(){
        gamePlayer.stop();
    }

    /**
     * Play menu sound.
     */
    public static void playMenuSound(){
        menuPlayer.play();
    }

    /**
     * Stop menu sound.
     */
    public static void stopMenuSound(){
        menuPlayer.stop();
    }
}
