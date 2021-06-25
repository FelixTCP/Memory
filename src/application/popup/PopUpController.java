package application.popup;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
     * Sets player name to content of the TextField and closes the PopUp
     * @param event Unused
     */

    @FXML
    void getName(ActionEvent event) {
        NewNamePopUp.p.setText(newName.getText());
        NewNamePopUp.window.close();
    }

}