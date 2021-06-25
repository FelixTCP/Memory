package application.popup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * <h2>The class PopUpController is used to manage the NewNamePopUp GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 *
 * @see NewNamePopUp
 */

public class PopUpController {

    @FXML
    private TextField newName;

    @FXML
    private Label nameLabel;

    @FXML
    private Button okButton;

    /**
     * Sets player name to content of the TextField and closes the Pop-Up upon pressind the "Fertig" button
     * @param event Unused
     */
    @FXML
    void getName(ActionEvent event) {
        NewNamePopUp.p.setText(newName.getText());
        NewNamePopUp.window.close();
    }
    /**
     * Sets player name to content of the TextField and closes the Pop-Up upon pressing the "Enter" key in the TextField
     * @param event Unused
     */
    @FXML
    void getNameEnter(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER){
            NewNamePopUp.p.setText(newName.getText());
            NewNamePopUp.window.close();
        }
    }

}