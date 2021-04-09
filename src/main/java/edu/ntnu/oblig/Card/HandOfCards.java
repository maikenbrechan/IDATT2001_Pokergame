package edu.ntnu.oblig.Card;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HandOfCards {
        ArrayList<PlayingCard> cards;

        /**
         * Constructor
         * @param numberOfCards
         * @param deck
         */
        public HandOfCards(int numberOfCards, DeckOfCards deck){
            cards = deck.dealHand(numberOfCards);
        }

        public ArrayList<PlayingCard> getCards(){return cards;}

        /**
         * Method that supports checkForFlush()
         * @param a
         * @return boolean
         */
        public boolean flush(char a){
            if(cards.stream().filter(p->p.getSuit()==a).count()>=5){
                return true;
            }
            return false;
        }

        /**
         * Checks if a hand of cards has flush
         * @return true for flush
         */

        public Boolean checkForFlush(){
            for(char b:DeckOfCards.getSuits()){
                if (flush(b)) {
                    return true;
                }
            }
            return false;
        }

    /**
     * Method that calculates points
     * @return sum of points on hand
     */
    public int sumPoints(){
             return cards.stream().map(PlayingCard::getFace).reduce(Integer::sum).get();
        }

        public ArrayList<PlayingCard> hearts(){
            ArrayList<PlayingCard> heart = cards.stream().filter(s -> s.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
            System.out.println(heart.stream().toString() + " ");
            return heart;
        }

    /**
     * Method that
     * @return true if hand contains Queen of Spades
     */
    public boolean checkForS12(){
            if(cards.stream().anyMatch(s->s.getSuit()=='S'&& s.getFace()==12)){
                return true;
            }
            return false;
        }

    /**
     * Standard toString()
     * @return String
     */
    @Override
    public String toString(){
        for(PlayingCard c : cards){
            return c.getAsString() +" ";
        }
        return null;
    }
}
