package application;

//TODO Add commentation

import application.logic.Card;
import application.logic.CardList;
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

    private CardList cards;

    @FXML
    public void initialize(){
        cards  = new CardList();
        cards.shuffle();
    }

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
        img0.setImage(new Image(cards.getCard(0).getImgURL()));
        img1.setImage(new Image(cards.getCard(1).getImgURL()));
        img2.setImage(new Image(cards.getCard(2).getImgURL()));
        img3.setImage(new Image(cards.getCard(3).getImgURL()));
        img4.setImage(new Image(cards.getCard(4).getImgURL()));
        img5.setImage(new Image(cards.getCard(5).getImgURL()));
        img6.setImage(new Image(cards.getCard(6).getImgURL()));
        img7.setImage(new Image(cards.getCard(7).getImgURL()));
        img8.setImage(new Image(cards.getCard(8).getImgURL()));
        img9.setImage(new Image(cards.getCard(9).getImgURL()));
        img10.setImage(new Image(cards.getCard(10).getImgURL()));
        img11.setImage(new Image(cards.getCard(11).getImgURL()));
        img12.setImage(new Image(cards.getCard(12).getImgURL()));
        img13.setImage(new Image(cards.getCard(13).getImgURL()));
        img14.setImage(new Image(cards.getCard(14).getImgURL()));
        img15.setImage(new Image(cards.getCard(15).getImgURL()));
        img16.setImage(new Image(cards.getCard(16).getImgURL()));
        img17.setImage(new Image(cards.getCard(17).getImgURL()));
        img18.setImage(new Image(cards.getCard(18).getImgURL()));
        img19.setImage(new Image(cards.getCard(19).getImgURL()));
        img20.setImage(new Image(cards.getCard(20).getImgURL()));
        img21.setImage(new Image(cards.getCard(21).getImgURL()));
        img22.setImage(new Image(cards.getCard(22).getImgURL()));
        img23.setImage(new Image(cards.getCard(23).getImgURL()));
        img24.setImage(new Image(cards.getCard(24).getImgURL()));
        img25.setImage(new Image(cards.getCard(25).getImgURL()));
        img26.setImage(new Image(cards.getCard(26).getImgURL()));
        img27.setImage(new Image(cards.getCard(27).getImgURL()));
        img28.setImage(new Image(cards.getCard(28).getImgURL()));
        img29.setImage(new Image(cards.getCard(29).getImgURL()));
        img30.setImage(new Image(cards.getCard(30).getImgURL()));
        img31.setImage(new Image(cards.getCard(31).getImgURL()));
        img32.setImage(new Image(cards.getCard(32).getImgURL()));
        img33.setImage(new Image(cards.getCard(33).getImgURL()));
        img34.setImage(new Image(cards.getCard(34).getImgURL()));
        img35.setImage(new Image(cards.getCard(35).getImgURL()));



    }
}