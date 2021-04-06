package edu.ntnu.oblig.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class HandOfCards {
        private int points = 0;
        private int amountOfCards=0;
        ArrayList<PlayingCard> cards = new ArrayList<>();

        /**
         * Constructor
         * @param numberOfCards
         * @param deck
         */
        public HandOfCards(int numberOfCards, DeckOfCards deck){
            this.amountOfCards=numberOfCards;
            cards= deck.dealHand(numberOfCards);
        }

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
    }