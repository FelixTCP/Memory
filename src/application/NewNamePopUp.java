package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h2>This class displays a Popup Alert used to set a new name for a player</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 25-06-2021
 */

public class NewNamePopUp {

    /**
     * Static method that displays the Popup
     * @param player The player that want to change name
     */
    public static void display(Label player){
        Stage window = new Stage();

        Label nameLabel = new Label("Bitte neuen Namen eingeben");
        TextField newName = new TextField();
        Button okButton = new Button("Fertig");

        okButton.setOnAction(e -> {
            player.setText(newName.getText());
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameLabel, newName, okButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);

        window.showAndWait();

    }

}
