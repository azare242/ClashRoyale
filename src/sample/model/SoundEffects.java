package sample.model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundEffects {
    public static void playErrorSound(){
        Media media = new Media(new File("src/sample/files/FXML/error.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
    }
}
