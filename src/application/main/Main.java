package application.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * <h2>The class Main is used to start the Application</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 24-06-2021
 *
 * @see Controller
 * @see javafx.application.Application
 * @see javafx.fxml.FXMLLoader
 */

public class Main extends Application {

    static Stage window;

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
     */
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        try {
            //Loads the .fxml as a javafx Scene
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MemoryGUI.fxml"));
            window.setScene(new Scene(root));
        }catch(Exception e){
            //This will never occur
            e.printStackTrace();
        }
        //As per default the window is in light mode
        disableDarkMode();
        //The window has the Title "Memory"
        window.setTitle("Memory");
        //The window cannot be resized
        window.setResizable(false);
        window.getIcons().add(new Image("images/hidden.png"));

        window.show();
    }

    /**
     * The method enableDarkMode is used to add a css file to the scene that enables dark mode
     */
    static void enableDarkMode(){
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(Main.class.getResource("/css/darkMode.css").toExternalForm());
    }

    /**
     * The method disableDarkMode is used to add a css file to the scene that enables light mode
     */
    static void disableDarkMode(){
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(Main.class.getResource("/css/lightMode.css").toExternalForm());
    }

    /**
     * Closes the Application
     */
    public static void close(){
        window.close();
    }
}
