package application;

import application.logic.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private ImageView img0;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;

    @FXML
    private ImageView img12;

    @FXML
    private ImageView img13;

    @FXML
    private ImageView img18;

    @FXML
    private ImageView img19;

    @FXML
    private ImageView img24;

    @FXML
    private ImageView img25;

    @FXML
    private ImageView img30;

    @FXML
    private ImageView img31;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img8;

    @FXML
    private ImageView img9;

    @FXML
    private ImageView img14;

    @FXML
    private ImageView img15;

    @FXML
    private ImageView img20;

    @FXML
    private ImageView img21;

    @FXML
    private ImageView img26;

    @FXML
    private ImageView img27;

    @FXML
    private ImageView img32;

    @FXML
    private ImageView img33;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img10;

    @FXML
    private ImageView img11;

    @FXML
    private ImageView img16;

    @FXML
    private ImageView img17;

    @FXML
    private ImageView img22;

    @FXML
    private ImageView img23;

    @FXML
    private ImageView img28;

    @FXML
    private ImageView img29;

    @FXML
    private ImageView img34;

    @FXML
    private ImageView img35;

    @FXML
    private Label player1;

    @FXML
    private Label player1Count;

    @FXML
    private Label player2;

    @FXML
    private Label player2Count;

    @FXML
    void addPointPlayerOne(MouseEvent event) {
        int count = Integer.parseInt(player1Count.getText())+1;
        player1Count.setText(count + "");
    }

    @FXML
    void addPointPlayerTwo(MouseEvent event) {
        int count = Integer.parseInt(player2Count.getText())+1;
        player2Count.setText(count + "");
    }

    @FXML
    void changeNamePlayerOne(MouseEvent event) {
        player1.setText("Felix");
    }

    @FXML
    void changeNamePlayerTwo(MouseEvent event) {
        player2.setText("Christian");
    }

    @FXML
    void changeImage(MouseEvent event) {
        img0.setImage(new Image("/images/Knerten.jpg"));
    }
}