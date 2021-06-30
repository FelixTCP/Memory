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
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MemoryGUI.fxml"));
            window.setScene(new Scene(root));
        }catch(Exception e){
            //this will never occur
            e.printStackTrace();
        }

        window.setTitle("Memory");
        window.getIcons().add(new Image("images/hidden.png"));

        disableDarkMode();

        window.setResizable(false);
        window.show();
    }


    static void enableDarkMode(){
        window.getScene().getStylesheets().clear();
        setUserAgentStylesheet(null);
        window.getScene().getStylesheets().add(Main.class.getResource("/css/darkMode.css").toExternalForm());
    }

    static void disableDarkMode(){
        window.getScene().getStylesheets().clear();
        setUserAgentStylesheet(null);
        window.getScene().getStylesheets().add(Main.class.getResource("/css/lightMode.css").toExternalForm());
    }

    /**
     * Closes the Application
     */
    public static void close(){
        window.close();
    }
}
