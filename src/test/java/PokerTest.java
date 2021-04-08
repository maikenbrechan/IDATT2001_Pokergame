import edu.ntnu.oblig.Card.DeckOfCards;
import edu.ntnu.oblig.Card.HandOfCards;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PokerTest {

DeckOfCards deck1;
HandOfCards hand1;

@BeforeEach
void setup(){
deck1 = new DeckOfCards();
hand1 = new HandOfCards(5, deck1);
}

@Test
void fiveCards(){
assertEquals(5, hand1.getCards().size());
}
}
