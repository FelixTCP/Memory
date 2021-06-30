package application.main;

import application.dialog.ChangeNameDialog;
import application.dialog.GameEndDialog;
import application.dialog.OptionsController;
import application.dialog.OptionsDialog;
import application.logic.CardList;
import application.logic.Player;
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
    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9;
    @FXML
    private ImageView img10, img11, img12, img13, img14, img15, img16, img17, img18, img19;
    @FXML
    private ImageView img20, img21, img22, img23, img24, img25, img26, img27, img28, img29;
    @FXML
    private ImageView img30, img31, img32, img33, img34, img35;


    @FXML
    private Label player1Name, player1Count, player2Name, player2Count;
    @FXML
    private ImageView playerOneOnMove, playerTwoOnMove;


    @FXML
    private ImageView player1img0, player1img1, player1img2, player1img3, player1img4;
    @FXML
    private ImageView player1img5, player1img6, player1img7, player1img8, player1img9;
    @FXML
    private ImageView player1img10, player1img11, player1img12, player1img13, player1img14;
    @FXML
    private ImageView player1img15, player1img16, player1img17;


    @FXML
    private ImageView player2img0, player2img1, player2img2, player2img3, player2img4;
    @FXML
    private ImageView player2img5, player2img6, player2img7, player2img8, player2img9;
    @FXML
    private ImageView player2img10, player2img11, player2img12, player2img13, player2img14;
    @FXML
    private ImageView player2img15, player2img16, player2img17;

    private CardList cards;

    private Player player1, player2;

    private int pairCount;

    private int flippedCardOne, flippedCardTwo;

    private String hiddenURL;

    /**
     * For better readablity this method outsources the creation of the array
     *
     * @return An array that contains ImageView objects of all Cards
     */
    ImageView[] getImageList() {
        return new ImageView[]{
                img0, img1, img2, img3, img4, img5,
                img6, img7, img8, img9, img10, img11,
                img12, img13, img14, img15, img16, img17,
                img18, img19, img20, img21, img22, img23,
                img24, img25, img26, img27, img28, img29,
                img30, img31, img32, img33, img34, img35
        };
    }

    /**
     * For better readablity this method outsources the creation of the array
     *
     * @return An array that contains mageView objects of all Cards that player one collected
     */
    ImageView[] getPlayerOneCardList(){
        return new ImageView[]{
                player1img0, player1img1, player1img2, player1img3, player1img4,
                player1img5, player1img6, player1img7, player1img8, player1img9,
                player1img10, player1img11, player1img12, player1img13, player1img14,
                player1img15, player1img16, player1img17
        };
    }

    /**
     * For better readablity this method outsources the creation of the array
     *
     * @return An array that contains mageView objects of all Cards that player two collected
     */
    ImageView[] getPlayerTwoCardList(){
        return new ImageView[]{
                player2img0, player2img1, player2img2, player2img3, player2img4,
                player2img5, player2img6, player2img7, player2img8, player2img9,
                player2img10, player2img11, player2img12, player2img13, player2img14,
                player2img15, player2img16, player2img17
        };
    }

    void resetHidden(){
        ImageView[] images = getImageList();

        for (ImageView image : images) {
            image.setImage(new Image(hiddenURL));
        }
    }

    void resetPlayerOneCards(){
        ImageView[] playerOneCards = getPlayerOneCardList();

        for (ImageView playerOneCard : playerOneCards) {
            playerOneCard.setImage(new Image("/images/-1.png"));
        }
    }

    void resetPlayerTwoCards(){
        ImageView[] playerTwoCards = getPlayerTwoCardList();

        for (ImageView playerTwoCard : playerTwoCards) {
            playerTwoCard.setImage(new Image("/images/-1.png"));
        }
    }

    /**
     * Sets all attributes back to their default values
     * Cards are newly shuffled and put back on the Board
     * Playernames are saved
     */
    public void reset() {
        cards = new CardList(OptionsDialog.getCurrentSet());
        cards.shuffle();

        pairCount = 18;
        flippedCardOne = -1;
        flippedCardTwo = -1;

        player1.setPoints(0);
        player2.setPoints(0);

        player1.setOnMove(true);
        player2.setOnMove(false);

        player1Count.setText(player1.getPoints() + "");
        player2Count.setText(player2.getPoints() + "");

        if (!OptionsController.isKeepNames()) {
            player1.setName("Spieler 1");
            player2.setName("Spieler 2");
            player1Name.setText(player1.getName());
            player2Name.setText(player2.getName());
        }

        playerOneOnMove.setImage(new Image("/images/OnMove.png"));
        playerTwoOnMove.setImage(new Image("/images/NotOnMove.png"));

        resetHidden();
        resetPlayerOneCards();
        resetPlayerTwoCards();
    }

    /**
     * Called when the GUI is launched
     * creates a new shuffled CardList
     */
    @FXML
    public void initialize() {
        player1 = new Player("Spieler 1", 0, true);
        player2 = new Player("Spieler 2", 0, false);

        hiddenURL = "/images/hidden.png";

        reset();
    }

    /**
     * Adds a point for player one
     *
     */
    @FXML
    void addPointPlayerOne() {
        player1.setPoints(player1.getPoints() + 1);
        player1Count.setText(player1.getPoints() + "");
    }

    /**
     * Adds a point for player two
     *
     */
    @FXML
    void addPointPlayerTwo() {
        player2.setPoints(player2.getPoints() + 1);
        player2Count.setText(player2.getPoints() + "");
    }

    /**
     * Changes name for player one
     *
     * @param event Unused
     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerOne(MouseEvent event) {
        ChangeNameDialog.display(player1);
        player1Name.setText(player1.getName());
    }

    /**
     * Changes name for player two
     *
     * @param event Unused
     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerTwo(MouseEvent event){
        ChangeNameDialog.display(player2);
        player2Name.setText(player2.getName());
    }

    /**
     * Changes the player that is on move - shown by a red circle next to the players name
     */
    void changeOnMove() {
        if (player1.isOnMove()) {
            player1.setOnMove(false);
            playerOneOnMove.setImage(new Image("/images/NotOnMove.png"));
            player2.setOnMove(true);
            playerTwoOnMove.setImage(new Image("/images/OnMove.png"));
        } else {
            player1.setOnMove(true);
            playerOneOnMove.setImage(new Image("/images/OnMove.png"));
            player2.setOnMove(false);
            playerTwoOnMove.setImage(new Image("/images/NotOnMove.png"));
        }
    }

    /**
     * Determines the winner - if both players have the same amount of point its a draw
     *
     * @return The winner
     */
    Player getWinner() {
        if (player1.getPoints() > player2.getPoints()) return player1;
        if (player1.getPoints() < player2.getPoints()) return player2;
        return new Player(null, 0, false);
    }

    /**
     * Flips the given Card (Card is calculated by mouse position)
     *
     * @param event Unused
     */
    @FXML
    void flipCard(MouseEvent event) {
        ImageView[] images = getImageList();

        int x = (int) Math.floor((event.getSceneX() - 350) / 100);
        int y = (int) Math.floor((event.getSceneY() - 70) / 100);
        int cardID = (6 * y + x);

        if (flippedCardOne == -1) {
            if (cards.getCard(cardID).isOnBoard()) {
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardOne = cardID;
            }
        } else if (flippedCardTwo == -1) {
            if (cardID != flippedCardOne && cards.getCard(cardID).isOnBoard()) {
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardTwo = cardID;
            }
        } else {
            if (cards.getCard(flippedCardOne).getPairID() == cards.getCard(flippedCardTwo).getPairID()) {
                if (player1.isOnMove()) {
                    ImageView[] collectedCardsOne = getPlayerOneCardList();
                    collectedCardsOne[player1.getPoints()].setImage(new Image(cards.getCard(flippedCardOne).getImgURL()));
                    addPointPlayerOne();
                } else {
                    ImageView[] collectedCardsTwo = getPlayerTwoCardList();
                    collectedCardsTwo[player2.getPoints()].setImage(new Image(cards.getCard(flippedCardOne).getImgURL()));
                    addPointPlayerTwo();
                }
                images[flippedCardOne].setImage(new Image("/images/-1.png"));
                images[flippedCardTwo].setImage(new Image("/images/-1.png"));
                cards.getCard(flippedCardOne).setOnBoard(false);
                cards.getCard(flippedCardTwo).setOnBoard(false);

                pairCount--;
                if (pairCount == 0 || (!OptionsController.isEndGame() && player1.getPoints() > 9 || player2.getPoints() > 9)) {
                    GameEndDialog.display(getWinner(), this);
                }

                if (OptionsController.isAlwaysSwap()) changeOnMove();
            } else {
                changeOnMove();

                images[flippedCardOne].setImage(new Image(hiddenURL));
                images[flippedCardTwo].setImage(new Image(hiddenURL));
            }
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
        ImageView[] images = getImageList();

        int i = 0;
        for (ImageView image : images) {
            image.setImage(new Image(cards.getCard(i).getImgURL()));
            i++;
        }
    }

    @FXML
    void displayOptions(){
        OptionsDialog.display();
        if(OptionsController.isDarkMode()){
            Main.enableDarkMode();
            hiddenURL = "/images/hiddenDark.png";
        }
        else{
            Main.disableDarkMode();
            hiddenURL = "/images/hidden.png";
        }
        resetHidden();
        if(OptionsController.somethingChanged) reset();
    }
}