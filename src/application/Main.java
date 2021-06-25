package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <h2>The class Main is used to start the Application</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 24-06-2021
 *
 * @see javafx.application.Application
 * @see javafx.fxml.FXMLLoader
 */

public class Main extends Application {

    /**
     * The main method is used to launch the Application
     * @param args Unused
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is called when the Application is launched
     * @param primaryStage The displayed GUI Stage
     * @throws Exception If the .fxml document can not be found
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MemoryGUI.fxml"));

        primaryStage.setTitle("Knerten Memory");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
