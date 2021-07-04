package application.dialog;

import application.main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *<h2>The class OptionsDialog displays the options menu</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 28-06-2021
 *
 * @see OptionsController
 */
public class OptionsDialog {
    private static Stage window;

    //The currently displayed set is saved in here
    private static String currentSet = "Tiere";

    /**
     * Static method that displays the options menu
     */
    public static void display(){
        window = new Stage();
        try {
            //Loads the .fxml as a javafx Scene
            Parent root = FXMLLoader.load(OptionsDialog.class.getResource("/fxml/Options.fxml"));
            window.setScene(new Scene(root));
        }catch(Exception e){
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

        //Displays the options menu
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

    /**
     * Returns the static window
     * @return window
     */
    public static Stage getWindow() {
        return window;
    }

    /**
     * Returns the currently selected set
     * @return currentSet
     */
    public static String getCurrentSet() {
        return currentSet;
    }

    /**
     * Sets the currently selected set
     * @param newSet The new set
     */
    public static void setCurrentSet(String newSet) {
        currentSet = newSet;
    }
}
