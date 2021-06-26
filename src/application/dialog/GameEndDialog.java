package application.dialog;

import application.logic.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GameEndDialog {

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
            Parent root = FXMLLoader.load(ChangeNameDialog.class.getResource("/fxml/GameEndDialog.fxml"));
            Scene scene = new Scene(root);
            window.setScene(scene);
        }catch(Exception e){

        }
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);

        window.showAndWait();

    }

}