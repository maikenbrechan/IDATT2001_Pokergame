package edu.ntnu.oblig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import edu.ntnu.oblig.Card.DeckOfCards;
import edu.ntnu.oblig.Card.HandOfCards;
import edu.ntnu.oblig.Card.PlayingCard;
import javafx.fxml.FXML;
import javafx.scene.CacheHint;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML Label label;
    @FXML TextField text;
    private DeckOfCards deck = new DeckOfCards();
    private HandOfCards hand;

    @FXML ImageView i1 = new ImageView();
    @FXML ImageView i2 = new ImageView();
    @FXML ImageView i3 = new ImageView();
    @FXML ImageView i4 = new ImageView();
    @FXML ImageView i5 = new ImageView();
    ArrayList<ImageView> images = new ArrayList<>(5);

    public void dealHand () throws FileNotFoundException {
            hand = new HandOfCards(5, deck);
            images.add(i1);
            images.add(i2);
            images.add(i3);
            images.add(i4);
            images.add(i5);
            showCards();
            System.out.println(hand.toString());
        }

        public void showCards () throws FileNotFoundException {
            for(int i=0; i<5; i++){
                images.get(i).setImage(new Image(new FileInputStream("cardsphoto/PNG/"+hand.getCards().get(i).getAsString() + ".png")));
            }
        }

        public void flush(){
            if(hand.checkForFlush()){
                text.setText("You've got flush!");
            }
            else{
                text.setText("Sorry you do not have a flush :(");
            }
        }

        public void countPoints(){
            int points = hand.checkHand();
            text.setText("Your points are: " + String.valueOf(points));
        }

        public void s12(){
        if(hand.checkForS12()){
            text.setText("Congrats! You've got Queen of Spades");
        }
        else{
            text.setText("Better luck next time!");
        }
        }
    }