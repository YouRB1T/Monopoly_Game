package card;

import event.TestEvent;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class CardStorageTest {

    private CardStorage cardStorage;
    private Card testCard1;
    private Card testCard2;

    @BeforeEach
    public void setUp() {
        cardStorage = new CardStorage(new HashSet<>());
        testCard1 = new TestCard(new TestEvent("Event for testCard1"),
                "Card 1", "Description 1");
        testCard2 = new TestCard(new TestEvent("Event for testCard2"),
                "Card 2", "Description 2");
    }

    @Test
    public void testAddCard() {
        cardStorage.addCard(testCard1);
        assertTrue(cardStorage.isCardInside(testCard1), "Card should be added to storage");
    }

    @Test
    public void testIsCardInside() {
        cardStorage.addCard(testCard1);
        assertTrue(cardStorage.isCardInside(testCard1), "Card should be inside storage");
        assertFalse(cardStorage.isCardInside(testCard2), "Card should not be inside storage");
    }

    @Test
    public void testDeleteCard() {
        cardStorage.addCard(testCard1);
        assertTrue(cardStorage.isCardInside(testCard1), "Card should be inside storage before deletion");

        cardStorage.deleteCard(testCard1);
        assertFalse(cardStorage.isCardInside(testCard1), "Card should be removed from storage after deletion");
    }

    @Test
    public void testDeleteNonExistentCard() {
        cardStorage.addCard(testCard1);
        assertTrue(cardStorage.isCardInside(testCard1), "Card should be inside storage before deletion");

        cardStorage.deleteCard(testCard2);
        assertTrue(cardStorage.isCardInside(testCard1), "Card 1 should still be inside storage");
    }

    @Test
    public void testSetCards() {
        HashSet<Card> newCards = new HashSet<>();
        newCards.add(testCard1);
        cardStorage.setCards(newCards);
        assertTrue(cardStorage.isCardInside(testCard1), "Card should be set correctly in storage");
    }

    @Test
    public void testGetCards() {
        cardStorage.addCard(testCard1);
        HashSet<Card> cards = cardStorage.getCards();
        assertTrue(cards.contains(testCard1), "Card should be retrievable from storage");
    }
}

