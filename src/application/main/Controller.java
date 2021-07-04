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


    //The pictures are displayed in a 6x6 board --> there are 36 images that are declared
    @FXML
    private ImageView img0, img1, img2, img3, img4, img5, img6, img7, img8, img9;
    @FXML
    private ImageView img10, img11, img12, img13, img14, img15, img16, img17, img18, img19;
    @FXML
    private ImageView img20, img21, img22, img23, img24, img25, img26, img27, img28, img29;
    @FXML
    private ImageView img30, img31, img32, img33, img34, img35;

    //Every player has a name and a amount of points that are shown
    @FXML
    private Label player1Name, player1Count, player2Name, player2Count;

    //The player that is on move is displayed by a red circle next to the players name
    @FXML
    private ImageView playerOneOnMove, playerTwoOnMove;

    //The players have small icons of the pairs that they have collected, that are displayed under their score
    //There are 18 pairs of cards in the game
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

    //All Card Objects are managed in the CardList
    private CardList cards;

    //There are two players in the game
    private Player player1, player2;

    //The pairCount tracks the number of pairs that are still in the game - if it goes to 0 the game ends
    private int pairCount;

    //The location of the flipped cards is temporarily saved in these attributes
    private int flippedCardOne, flippedCardTwo;

    //This string is used to save the location of the image that is displayed if the card is hidden
    //The location can change dependant on the selected visual mode: Either light or dark
    private String hiddenURL;

    /**
     * For better readability this method outsources the creation of the array in which all images are stored
     *
     * @return An array that contains the ImageView objects of all Cards
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
     * For better readability this method outsources the creation of the array in which all playerOneCards are stored
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
     * For better readability this method outsources the creation of the array in which all playerTwoCards are stored
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

    /**
     * The resetHidden method is used to newly render all hidden images that are still in the game
     */
    void resetHidden(){
        ImageView[] images = getImageList();

        int i = 0;
        for (ImageView image : images) {
            if(cards.getCard(i).isOnBoard() && flippedCardOne != i  && flippedCardTwo != i){
                image.setImage(new Image(hiddenURL));
            }
            i++;
        }
    }

    /**
     * The resetPlayerOneCards method is used to delete all icons of the pairs that player one has collected
     */
    void resetPlayerOneCards(){
        ImageView[] playerOneCards = getPlayerOneCardList();

        for (ImageView playerOneCard : playerOneCards) {
            playerOneCard.setImage(new Image("/images/-1.png"));
        }
    }

    /**
     * The resetPlayerTwoCards method is used to delete all icons of the pairs that player two has collected
     */
    void resetPlayerTwoCards(){
        ImageView[] playerTwoCards = getPlayerTwoCardList();

        for (ImageView playerTwoCard : playerTwoCards) {
            playerTwoCard.setImage(new Image("/images/-1.png"));
        }
    }

    /**
     * The reset method is used to reset all attributes back to their default values -
     * Cards are newly shuffled and put back on the Board
     */
    public void reset() {
        //Creates a new CardList that includes all cards of the given set (default value is animals)
        cards = new CardList(OptionsDialog.getCurrentSet());
        //The array is shuffled
        cards.shuffle();

        //Default values are set
        pairCount = 18;
        flippedCardOne = -1;
        flippedCardTwo = -1;
        player1.setPoints(0);
        player2.setPoints(0);
        player1Count.setText(player1.getPoints() + "");
        player2Count.setText(player2.getPoints() + "");
        player1.setOnMove(true);
        player2.setOnMove(false);
        playerOneOnMove.setImage(new Image("/images/OnMove.png"));
        playerTwoOnMove.setImage(new Image("/images/NotOnMove.png"));


        //Resets names if option is enabled
        if (!OptionsController.isKeepNames()) {
            player1.setName("Spieler 1");
            player2.setName("Spieler 2");
            player1Name.setText(player1.getName());
            player2Name.setText(player2.getName());
        }

        //All images are reset
        resetHidden();
        resetPlayerOneCards();
        resetPlayerTwoCards();
    }

    /**
     * Called when the GUI is launched -
     * Creates two players and sets all attributes to their default values by using the reset() method
     */
    @FXML
    public void initialize() {
        player1 = new Player("Spieler 1", 0, true);
        player2 = new Player("Spieler 2", 0, false);

        //The default visual mode is light
        hiddenURL = "/images/hidden.png";

        reset();
    }

    /**
     * Adds a point for player one
     */
    void addPointPlayerOne() {
        player1.setPoints(player1.getPoints() + 1);
        player1Count.setText(player1.getPoints() + "");
    }

    /**
     * Adds a point for player two
     */
    void addPointPlayerTwo() {
        player2.setPoints(player2.getPoints() + 1);
        player2Count.setText(player2.getPoints() + "");
    }

    /**
     * Changes name for player one
     *
Dw     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerOne() {
        ChangeNameDialog.display(player1);
        player1Name.setText(player1.getName());
    }

    /**
     * Changes name for player two
     *
     * @see ChangeNameDialog
     */
    @FXML
    void changeNamePlayerTwo(){
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

        //If the players name is null the EndGameDialog will display a draw
        return new Player(null, 0, false);
    }

    /**
     * Flips the given Card (Card is calculated by mouse position)
     *
     * @param event Used to calculated the Cards the player has clicked at
     */
    @FXML
    void flipCard(MouseEvent event) {
        ImageView[] images = getImageList();

        //The board is placed 350 pixels right and 70 pixels down of the left upper corner of the window
        int x = (int) Math.floor((event.getSceneX() - 350) / 100);
        int y = (int) Math.floor((event.getSceneY() - 70) / 100);

        //(Bodging) Used to get the correct location even if the mouse is slightly off to the right or left side of the board
        if(x == -1) x = 0;
        if(x == 6) x = 5;

        int cardID = (6 * y + x);

        //If no card has been flipped already
        if (flippedCardOne == -1) {
            //If the card is still in the game, it has not been collected yet
            if (cards.getCard(cardID).isOnBoard()) {
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardOne = cardID;
            }
        }
        //If one card has been flipped already
        else if (flippedCardTwo == -1) {
            //If the card is still in the game, it has not been collected yet AND it is not the same as the previous card
            if (cardID != flippedCardOne && cards.getCard(cardID).isOnBoard()) {
                images[cardID].setImage(new Image(cards.getCard(cardID).getImgURL()));
                flippedCardTwo = cardID;
            }
        }
        //If two cards have been flipped already
        else {
            if (cards.getCard(flippedCardOne).getPairID() == cards.getCard(flippedCardTwo).getPairID()) {
                if (player1.isOnMove()) {
                    //The cards image is added as an icon
                    ImageView[] collectedCardsOne = getPlayerOneCardList();
                    collectedCardsOne[player1.getPoints()].setImage(new Image(cards.getCard(flippedCardOne).getImgURL()));
                    //Player one gets one point
                    addPointPlayerOne();
                } else {
                    //The cards image is added as an icon
                    ImageView[] collectedCardsTwo = getPlayerTwoCardList();
                    collectedCardsTwo[player2.getPoints()].setImage(new Image(cards.getCard(flippedCardOne).getImgURL()));
                    //Player two gets one point
                    addPointPlayerTwo();
                }
                //The cards are now displaying an empty image
                images[flippedCardOne].setImage(new Image("/images/-1.png"));
                images[flippedCardTwo].setImage(new Image("/images/-1.png"));
                //The cards are no longer in the game
                cards.getCard(flippedCardOne).setOnBoard(false);
                cards.getCard(flippedCardTwo).setOnBoard(false);

                pairCount--;
                //Checks if the game has ended
                if (pairCount == 0 || (!OptionsController.isEndGame() && player1.getPoints() > 9 || player2.getPoints() > 9)) {
                    //Displays the GameEndDialog that shows the winner
                    GameEndDialog.display(getWinner(), this);
                }

                //Changes the player that is on move if enabled
                if (OptionsController.isAlwaysSwap()) changeOnMove();
            } else {
                //Changes the player that is on move
                changeOnMove();

                //Flips the cards back
                images[flippedCardOne].setImage(new Image(hiddenURL));
                images[flippedCardTwo].setImage(new Image(hiddenURL));
            }
            //Default values are set
            flippedCardOne = -1;
            flippedCardTwo = -1;
        }
    }

    /**
     * Flips all cards (used for debug)
     */
    @FXML
    void flipAllCards() {
        ImageView[] images = getImageList();

        int i = 0;
        for (ImageView image : images) {
            image.setImage(new Image(cards.getCard(i).getImgURL()));
            i++;
        }
    }

    /**
     * The displayOptions method is used to open the OptionsDialog and change the settings
     *
     * @see OptionsDialog
     */
    @FXML
    void displayOptions(){
        //Displays the OptionsDialog
        OptionsDialog.display();

        //Changes css according to options
        if(OptionsController.isDarkMode()){
            Main.enableDarkMode();
            hiddenURL = "/images/hiddenDark.png";
        }
        else{
            Main.disableDarkMode();
            hiddenURL = "/images/hidden.png";
        }
        //Renders all hidden images new
        resetHidden();
        //If something other than the visual mode has changed the game will reset
        if(OptionsController.somethingChanged) reset();
    }
}