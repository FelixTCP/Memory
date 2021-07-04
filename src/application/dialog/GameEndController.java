package application.dialog;

import application.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *<h2>The class GameEndController is used to manage the GameEndDialog GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 26-06-2021
 *
 * @see GameEndDialog
 */

public class GameEndController {

    @FXML
    private Label gameEndLabel;

    @FXML
    private Label winnerLabel;

    @FXML
    private Button replayButton;

    @FXML
    private Button endButton;

    /**
     * Called when the game is finished - Sets the winnerLabel to display the winner
     */
    @FXML
    public void initialize(){
        if (GameEndDialog.currentPlayer.getName() == null) {
            winnerLabel.setText("Es ist ein Unentschieden!");
        }else{
            winnerLabel.setText(GameEndDialog.currentPlayer.getName() + " gewinnt das Spiel!");
        }
    }

    /**
     * Closes the Application
     */
    @FXML
    void close() {
        GameEndDialog.window.close();
        Main.close();
    }

    /**
     * Restarts the game
     */
    @FXML
    void replay() {
        GameEndDialog.main.reset();
        GameEndDialog.window.close();
    }

}

