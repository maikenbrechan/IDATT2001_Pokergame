package edu.ntnu.oblig.Card;

import java.util.ArrayList;
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

        /**
         * Return amount of cards of one suit
         * @param suit
         * @return sum
         */
        public int amountOfSuit(char suit){
            int sum=0;
            for(PlayingCard card:cards){
                if(card.getSuit()==suit){
                    sum++;
                }
            }
            return sum;
        }

        /**
         * Checks if a hand of cards has flush
         * @return true for flush
         */

        public Boolean checkForFlush(){
            for(char b:DeckOfCards.getSuits()){
                if (amountOfSuit(b) == 5) {
                    points=5;
                    return true;
                }
            }
            return false;
        }

        public boolean flush(char a){
            return true;
        }
    }