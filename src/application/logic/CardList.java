package application.logic;

import java.util.ArrayList;

public class CardList {

    private ArrayList<Card> deepList;
    private ArrayList<Card> workList;

    private void createCards(){
        for (int i = 1; i <= 36; i++) {
            String imgURL = "/images/"+i%18+".png";
            deepList.add(new Card(imgURL, i%18));
        }
    }

    public CardList(){
        deepList = new ArrayList<>();
        workList = new ArrayList<>();

        createCards();

        for (Card card : deepList) {
            workList.add(card.copy());
        }
    }

    public ArrayList<Card> resetList(){
        workList = new ArrayList<>();
        for (Card card : deepList) {
            workList.add(card.copy());
        }
        return workList;
    }

}
