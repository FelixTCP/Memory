package application.dialog;

import application.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameEndController {

    @FXML
    private Label gameEndLabel;

    @FXML
    private Label winnerLabel;

    @FXML
    private Button replayButton;

    @FXML
    private Button endButton;

    @FXML
    public void initialize(){
        if (GameEndDialog.currentPlayer.getName().equals("Keiner")) {
            winnerLabel.setText("Unentschieden!");
        }else{
            winnerLabel.setText(GameEndDialog.currentPlayer.getName() + " gewinnt das Spiel!");
        }
    }

    @FXML
    void close(ActionEvent event) {
        GameEndDialog.window.close();
        Main.close();
    }

    @FXML
    void replay(ActionEvent event) {

    }

}

