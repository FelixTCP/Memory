package application.logic;

//TODO Add commentation

import java.util.ArrayList;
import java.util.Collections;

public class CardList {

    private ArrayList<Card> deepList;
    private ArrayList<Card> workList;

    private void createCards(){
        for (int i = 0; i < 36; i++) {
            String imgURL = "/images/"+i%18+".png";
            deepList.add(new Card(imgURL, i%18));
        }
    }

    public CardList(){
        deepList = new ArrayList<>();
        workList = new ArrayList<>();

        createCards();

        workList = (ArrayList<Card>) deepList.clone();
    }

    public void resetList(){
        workList = (ArrayList<Card>) deepList.clone();
    }

    public void shuffle(){
        Collections.shuffle(workList);
    }

    public ArrayList<Card> getList(){
        return workList;
    }

    public Card getCard(int index){
        return workList.get(index);
    }



}
