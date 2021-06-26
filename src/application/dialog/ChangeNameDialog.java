package application.dialog;

import application.logic.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h2>The class NewNamePopUp is displays a Popup Alert used to set a new name for a player</h2>
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
    public static void display(Player player) throws Exception {
        currentPlayer = player;

        window = new Stage();
        Parent root = FXMLLoader.load(ChangeNameDialog.class.getResource("/fxml/ChangeNameDialog.fxml"));

        Scene scene = new Scene(root);
        window.setScene(scene);

        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);

        window.showAndWait();

    }

}
