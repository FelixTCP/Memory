package application.dialog;

import application.logic.Player;
import application.main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h2>The class ChangeNameDialog displays a Pop-Up Alert used to set a new name for a player</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 */

public class ChangeNameDialog {

    static Player currentPlayer;
    static Stage window;

    /**
     * Static method that displays the Pop-Up
     * @param player The player that wants to change name
     */
    public static void display(Player player){
        currentPlayer = player;

        window = new Stage();
        try {
            Parent root = FXMLLoader.load(ChangeNameDialog.class.getResource("/fxml/ChangeNameDialog.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
        } catch (IOException e) {
            //this will never occur
            e.printStackTrace();
        }

        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);

        if(OptionsController.isDarkMode()) enableDarkMode();
        else disableDarkMode();

        window.showAndWait();

    }

    static void enableDarkMode(){
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(Main.class.getResource("/css/darkMode.css").toExternalForm());
    }

    static void disableDarkMode(){
        window.getScene().getStylesheets().clear();
        window.getScene().getStylesheets().add(Main.class.getResource("/css/lightMode.css").toExternalForm());
    }
}
