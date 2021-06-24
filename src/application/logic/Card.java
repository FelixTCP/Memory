package application.logic;

public class Card {
    private String imgURL;
    private int pairID;

    public Card(String imgURL, int pairID) {
        this.imgURL = imgURL;
        this.pairID = pairID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public int getPairID() {
        return pairID;
    }

    public Card copy(){return new Card(imgURL,pairID);}
}
