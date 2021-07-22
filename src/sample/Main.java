package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controllers.LoginRegisterController;

/**
 * START OF APP
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("files/FXML/login-registerScene.fxml"));
            LoginRegisterController controller = new LoginRegisterController();
            loader.setController(controller);
            Parent root = loader.load();
            primaryStage.setTitle("Clash Royal");
            primaryStage.setScene(new Scene(root, 321, 447));
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
