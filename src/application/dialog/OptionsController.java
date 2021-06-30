package application.dialog;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

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

    private static boolean endGame = true;
    private static boolean keepNames = true;
    private static boolean alwaysSwap = false;
    private static boolean darkMode = false;

    private static String selectedSet = "Tiere";

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

    @FXML
    void initialize() {
        somethingChanged = false;

        endGameBox.setSelected(isEndGame());
        keepNamesBox.setSelected(isKeepNames());
        alwaysSwapBox.setSelected(isAlwaysSwap());
        darkModeBox.setSelected(isDarkMode());

        setsComboBox.getItems().addAll("Tiere", "Essen", "Blumen", "League Champs");
        setsComboBox.getSelectionModel().select(selectedSet);
    }

    @FXML
    void applyChanges() {
        if(endGame != endGameBox.isSelected() ||
           keepNames != keepNamesBox.isSelected() ||
           alwaysSwap != alwaysSwapBox.isSelected() ||
           selectedSet != setsComboBox.getValue())
        {
            somethingChanged = true;
        }

        endGame = endGameBox.isSelected();
        keepNames = keepNamesBox.isSelected();
        alwaysSwap = alwaysSwapBox.isSelected();
        darkMode = darkModeBox.isSelected();

        OptionsDialog.setCurrentSet(setsComboBox.getValue());

        selectedSet = setsComboBox.getValue();

        OptionsDialog.window.close();
    }

    @FXML
    void close() {
        OptionsDialog.window.close();
    }

}
