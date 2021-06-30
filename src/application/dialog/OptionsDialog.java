package application.dialog;

import application.main.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OptionsDialog {


    public static Stage window;

    private static String currentSet = "Tiere";

    public static String getCurrentSet() {
        return currentSet;
    }

    public static void setCurrentSet(String set) {
        currentSet = set;
    }

    public static void display(){
        window = new Stage();
        try {
            Parent root = FXMLLoader.load(OptionsDialog.class.getResource("/fxml/Options.fxml"));
            window.setScene(new Scene(root));
        }catch(Exception e){
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
