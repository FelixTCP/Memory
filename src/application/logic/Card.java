package application.logic;

/**
 * <h2>The class Card is used to manage the Memory-Cards in the GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 24-06-2021
 */

public class Card {
    private String imgURL;
    private int pairID;

    /**
     * @param imgURL Used to reference the Image (.png) that the Card should display
     * @param pairID Every pair of cards has a specific pairID that is used to check if that correct pair was found
     */
    public Card(String imgURL, int pairID) {
        this.imgURL = imgURL;
        this.pairID = pairID;
    }

    /**
     * Returns the imgURL
     * @return imgURL
     */
    public String getImgURL() {
        return imgURL;
    }

    /**
     * Returns the pairID
     * @return pairID
     */
    public int getPairID() {
        return pairID;
    }
}
