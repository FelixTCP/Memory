package application.main;

//TODO Add commentation

import application.logic.CardList;
import application.logic.Player;
import application.dialog.ChangeNameDialog;
import application.dialog.GameEndDialog;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * <h2>The class Controller is used to manage the GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @see CardList
 * @since 24-06-2021
 */
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
    private Label player1Name;

    @FXML
    private Label player1Count;

    @FXML
    private Label player2Name;

    @FXML
    private Label player2Count;

    @FXML
    private ImageView playerOneOnMove;

    @FXML
    private ImageView playerTwoOnMove;


    private CardList cards;

    private Player player1;
    private Player player2;

    private int pairCount;

    private int flipped;

    private int flippedCardOne;
    private int flippedCardTwo;

    /**
     * Called when the GUI is launched
     * creates a new shuffled CardList
     */
    @FXML
    public void initialize() {
        cards = new CardList();
        cards.shuffle();

        pairCount = 18;

        flipped = 0;
        flippedCardOne = -1;
        flippedCardTwo = -1;

        player1 = new Player("Spieler 1", 0, true);
        player2 = new Player("Spieler 2", 0, false);

        playerOneOnMove.setImage(new Image("/images/OnMove.png"));


    }

    /**
     * Adds a point for player one
     *
     * @param event Unused
     */
    @FXML
    void addPointPlayerOne(MouseEvent event) {
        player1.setPoints(player1.getPoints()+1);
        player1Count.setText(player1.getPoints() + "");
    }

    /**
     * Adds a point for player two
     *
     * @param event Unused
     */
    @FXML
    void addPointPlayerTwo(MouseEvent event) {
        player2.setPoints(player2.getPoints()+1);
        player2Count.setText(player2.getPoints() + "");
    }

    /**
     * Changes name for player one
     *
     * @param event Unused
     * @throws Exception If the ChangeNameDialog.fxml can not be found
     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerOne(MouseEvent event) throws Exception {
        ChangeNameDialog.display(player1);
        player1Name.setText(player1.getName());
    }

    /**
     * Changes name for player two
     *
     * @param event Unused
     * @throws Exception If the ChangeNameDialog.fxml can not be found
     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerTwo(MouseEvent event) throws Exception {
        ChangeNameDialog.display(player2);
        player2Name.setText(player2.getName());
    }

    void changeOnMove(){
        if(player1.isOnMove()){
            player1.setOnMove(false);
            playerOneOnMove.setImage(new Image("/images/NotOnMove.png"));
            player2.setOnMove(true);
            playerTwoOnMove.setImage(new Image("/images/OnMove.png"));
        }else{
            player2.setOnMove(false);
            playerTwoOnMove.setImage(new Image("/images/NotOnMove.png"));
            player1.setOnMove(true);
            playerOneOnMove.setImage(new Image("/images/OnMove.png"));
        }
    }

    Player getWinner(){
        if(player1.getPoints() > player2.getPoints()) return player1;
        if(player1.getPoints() < player2.getPoints()) return player2;
        return new Player("Keiner",0,false);
    }

    /**
     * Flips the given Card
     *
     * @param event Unused
     */
    @FXML
    void flipCard(MouseEvent event){
        int x = (int) Math.floor((event.getSceneX() - 350) / 100);
        int y = (int) Math.floor((event.getSceneY() - 70) / 100);
        int cardID = (6 * y + x);

        ImageView[] images = {
                img0,img1,img2,img3,img4,img5,
                img6,img7,img8,img9,img10,img11,
                img12,img13,img14,img15,img16,img17,
                img18,img19,img20,img21,img22,img23,
                img24,img25,img26,img27,img28,img29,
                img30,img31,img32,img33,img34,img35
        };

        if (flipped == 0) {
            if (cards.getCard(cardID).isOnBoard()){
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardOne = cardID;
                flipped++;
            }
        }else if(flipped == 1){
            if (cardID != flippedCardOne && cards.getCard(cardID).isOnBoard()) {
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardTwo = cardID;
                flipped++;
            }
        }else{
            if(cards.getCard(flippedCardOne).getPairID() == cards.getCard(flippedCardTwo).getPairID()){

                if(player1.isOnMove()){
                    addPointPlayerOne(null);
                }else{
                    addPointPlayerTwo(null);
                }

                images[flippedCardOne].setImage(new Image("/images/-1.png"));
                images[flippedCardTwo].setImage(new Image("/images/-1.png"));
                cards.getCard(flippedCardOne).setOnBoard(false);
                cards.getCard(flippedCardTwo).setOnBoard(false);

                pairCount--;
                if(pairCount == 0){
                    GameEndDialog.display(getWinner());
                }
            }else{

                changeOnMove();

                images[flippedCardOne].setImage(new Image("/images/hidden.png"));
                images[flippedCardTwo].setImage(new Image("/images/hidden.png"));
            }
            flipped = 0;
            flippedCardOne = -1;
            flippedCardTwo = -1;
        }
    }

    /**
     * Flips all cards (used for debug)
     *
     * @param event Unused
     */
    @FXML
    void flipAllCards(MouseEvent event) {
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