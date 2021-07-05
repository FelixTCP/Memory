package application.dialog;

import application.logic.Player;
import application.main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h2>The class ChangeNameDialog displays a Pop-Up Alert used to set a new name for a player</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 */

public class ChangeNameDialog {
    //The player whose name should be changed
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
            //Loads the .fxml as a javafx Scene
            Parent root = FXMLLoader.load(ChangeNameDialog.class.getResource("/fxml/ChangeNameDialog.fxml"));
            window.setScene(new Scene(root));
        } catch (Exception e) {
            //This will never occur
            e.printStackTrace();
        }
        //The window has to be answered
        window.initModality(Modality.APPLICATION_MODAL);
        //The window cannot be resized
        window.setResizable(false);

        //Loads css for dark mode if enabled
        if(OptionsController.isDarkMode()) enableDarkMode();
        else disableDarkMode();

        //Displays the change name menu
        window.showAndWait();

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
}
