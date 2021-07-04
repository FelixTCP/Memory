package application.dialog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * <h2>The class ChangeNameController is used to manage the ChangeNameDialog GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 *
 * @see ChangeNameDialog
 */

public class ChangeNameController {

    @FXML
    private TextField newName;

    @FXML
    private Label nameLabel;

    @FXML
    private Button okButton;

    /**
     * Sets player name to content of the TextField and closes the Pop-Up upon pressing the "Fertig" button
     */
    @FXML
    void getName() {
        ChangeNameDialog.currentPlayer.setName(newName.getText());
        ChangeNameDialog.window.close();
    }
    /**
     * Sets player name to content of the TextField and closes the Pop-Up upon pressing the ENTER key in the TextField
     * @param event Used to detect whether the ENTER key has been pressed
     */
    @FXML
    void getNameEnter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            ChangeNameDialog.currentPlayer.setName(newName.getText());
            ChangeNameDialog.window.close();
        }
    }

}