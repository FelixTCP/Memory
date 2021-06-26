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

    private ArrayList<Card> deepList;
    private ArrayList<Card> workList;

    /**
     * Used to fill the deeplist with cards
     */
    private void createCards(){
        for (int i = 0; i < 36; i++) {
            String imgURL = "/images/"+i%18+".png";
            deepList.add(new Card(imgURL, i%18, true));
        }
    }


    /**
     * Creates a deeplist and a worklist and fills both with cards
     */
    public CardList(){
        deepList = new ArrayList<>();
        workList = new ArrayList<>();

        createCards();

        workList = (ArrayList<Card>) deepList.clone();
    }

    /**
     * Resets the worklist to default (deeplist) state
     */
    public void resetList(){
        workList = (ArrayList<Card>) deepList.clone();
    }

    /**
     * Randomly shuffles all contents of the worklist
     */
    public void shuffle(){
        Collections.shuffle(workList);
    }

    /**
     * Returns the worklist object
     * @return worklist
     */
    public ArrayList<Card> getList(){
        return workList;
    }

    /**
     *
     * @param index Used to reference a card in the list by its index
     * @return The card with the given index
     */
    public Card getCard(int index){
        return workList.get(index);
    }
}
