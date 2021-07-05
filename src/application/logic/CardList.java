package application.logic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h2>The class CardList is used to reference the Memory-Cards in the GUI</h2>
 *
 * @author Felix Wensky
 * @version 1.0.0
 * @since 24-06-2021
 *
 * @see application.logic.Card
 */

public class CardList {

    private ArrayList<Card> cardList;

    /**
     * Used to fill the cardList with cards
     */
    private void createCards(String set){
        for (int i = 0; i < 36; i++) {
            String imgURL = "/images/"+set.toLowerCase()+"/"+i%18+".jpg";
            cardList.add(new Card(imgURL, i%18, true));
        }
    }

    /**
     * Creates a cardList and fills it with cards
     */
    public CardList(String set){
        cardList = new ArrayList<>();

        createCards(set);
    }

    /**
     * Randomly shuffles all contents of the cardList
     */
    public void shuffle(){
        Collections.shuffle(cardList);
    }

    /**
     * @param index Used to reference a card in the list by its index
     * @return The card with the given index
     */
    public Card getCard(int index){
        return cardList.get(index);
    }
}
