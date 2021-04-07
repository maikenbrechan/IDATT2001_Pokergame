package edu.ntnu.oblig.Card;

import javafx.print.PageLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class HandOfCards {
        private int points = 0;
        ArrayList<PlayingCard> cards = new ArrayList<>();

        /**
         * Constructor
         * @param numberOfCards
         * @param deck
         */
        public HandOfCards(int numberOfCards, DeckOfCards deck){
            cards= deck.dealHand(numberOfCards);
        }

        public ArrayList<PlayingCard> getCards(){return cards;}

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

        public int checkHand(){
             return cards.stream().map(PlayingCard::getFace).reduce((a,b) -> (a + b)).get();
        }

        public ArrayList<PlayingCard> hearts(){
            ArrayList<PlayingCard> heart = cards.stream().filter(s -> s.getSuit() == 'H').collect(Collectors.toCollection(ArrayList::new));
            System.out.println(heart.stream().toString() + " ");
            return heart;
        }

        public boolean checkForS12(){
            if(cards.stream().anyMatch(s->s.getSuit()=='S'&& s.getFace()==12)){
                return true;
            }
            return false;
        }
}