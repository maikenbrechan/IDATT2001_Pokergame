package edu.ntnu.oblig.Card;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<PlayingCard> deck = new ArrayList<>(52);
    private static final char[] suits = {'H','C','S','D'};
    private Random random = new Random();

    public DeckOfCards(){
        for(char suit: suits){
            for(int j=1; j<14; j++){
                deck.add(new PlayingCard(suit, j));
            }
        }
    }
    public static char[] getSuits(){return suits;}

    public ArrayList<PlayingCard> dealHand(int n){
        ArrayList<PlayingCard> hand = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            int randomNumber = random.nextInt(deck.size());
            hand.add(deck.get(randomNumber));
            deck.remove(randomNumber);
        }
        return hand;
    }
}
