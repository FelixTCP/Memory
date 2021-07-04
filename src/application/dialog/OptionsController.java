package application.dialog;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

/**
 *<h2>The class OptionsController is used to manage the OptionsDialog GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 28-06-2021
 *
 * @see OptionsDialog
 */
public class OptionsController {

    @FXML
    private CheckBox endGameBox;

    @FXML
    private CheckBox keepNamesBox;

    @FXML
    private CheckBox alwaysSwapBox;

    @FXML
    private CheckBox darkModeBox;

    @FXML
    private ComboBox<String> setsComboBox;

    @FXML
    private Button applyButton;

    @FXML
    private Button closeButton;

    //Default values
    private static boolean endGame = true;
    private static boolean keepNames = true;
    private static boolean alwaysSwap = false;
    private static boolean darkMode = false;
    private static String selectedSet = "Tiere";

    //True if something else then the visual mode changed
    public static boolean somethingChanged;

    public static boolean isEndGame() {
        return endGame;
    }

    public static boolean isKeepNames() {
        return keepNames;
    }

    public static boolean isAlwaysSwap() {
        return alwaysSwap;
    }

    public static boolean isDarkMode() {
        return darkMode;
    }

    /**
     * Called when the window is displayed - Sets all items to their current values
     */
    @FXML
    void initialize() {
        somethingChanged = false;

        endGameBox.setSelected(isEndGame());
        keepNamesBox.setSelected(isKeepNames());
        alwaysSwapBox.setSelected(isAlwaysSwap());
        darkModeBox.setSelected(isDarkMode());

        setsComboBox.getItems().addAll("Tiere", "Essen", "Blumen", "League Champs", "Söder");
        setsComboBox.getSelectionModel().select(selectedSet);
    }

    /**
     * Called upon pressing the Apply Button - Sets all options to their new values
     */
    @FXML
    void applyChanges() {
        //Checks if something changed
        if(endGame != endGameBox.isSelected() ||
           keepNames != keepNamesBox.isSelected() ||
           alwaysSwap != alwaysSwapBox.isSelected() ||
           !selectedSet.equals(setsComboBox.getValue()))
        {
            somethingChanged = true;
        }

        endGame = endGameBox.isSelected();
        keepNames = keepNamesBox.isSelected();
        alwaysSwap = alwaysSwapBox.isSelected();
        darkMode = darkModeBox.isSelected();

        //Sets the current set of cards
        OptionsDialog.setCurrentSet(setsComboBox.getValue());

        selectedSet = setsComboBox.getValue();

        OptionsDialog.getWindow().close();
    }

    /**
     * Called upon pressing the Close Button - Closes the window
     */
    @FXML
    void close() {
        OptionsDialog.getWindow().close();
    }

}
