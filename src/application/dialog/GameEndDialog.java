package application.dialog;

import application.logic.Player;
import application.main.Controller;
import application.main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *<h2>The class GameEndDialog displays Pop-Up Alert when the game has ended</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 26-06-2021
 *
 * @see GameEndDialog
 */

public class GameEndDialog {

    static Player currentPlayer;
    static Stage window;
    static Controller main;

    /**
     * Static method that displays the Pop-Up
     * @param player The player that wants to change name
     */
    public static void display(Player player, Controller mainWindow){
        currentPlayer = player;
        main = mainWindow;

        window = new Stage();
        try {
            Parent root = FXMLLoader.load(ChangeNameDialog.class.getResource("/fxml/GameEndDialog.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
        }catch(Exception e){
            //this will never occur
            e.printStackTrace();
        }

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