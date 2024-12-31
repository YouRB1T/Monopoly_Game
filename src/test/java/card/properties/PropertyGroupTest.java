package card.properties;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardStorage;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.PropertyGroup;
import monopoly.entity.events.PayRentEvent;
import monopoly.entity.roles.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PropertyGroupTest {
    private PropertyGroup propertyGroup;
    private Card card1;
    private Card card2;
    private Player player;

    @BeforeEach
    void setUp() {
        propertyGroup = new PropertyGroup("Test Group");
        card1 = new PropertyCard(new PayRentEvent(),"Card 1", "desc 1");
        card2 = new PropertyCard(new PayRentEvent(), "Card 2", "desc 2");
        player = new Player("Player 1");

        player.addCard(card1);
        player.addCard(card2);
    }

    @Test
    void testAddCard() {
        propertyGroup.addCard(card1);
        assertTrue(propertyGroup.getCards().contains(card1));
    }

    @Test
    void testHasAllCardsTrue() {
        propertyGroup.addCard(card1);
        propertyGroup.addCard(card2);
        assertTrue(propertyGroup.hasAllCards(player));
    }

    @Test
    void testHasAllCardsFalse() {
        propertyGroup.addCard(card1);
        assertFalse(propertyGroup.hasAllCards(player));
    }

    @Test
    void testDeleteCard() {
        propertyGroup.addCard(card1);
        propertyGroup.deleteCard(card1);
        assertFalse(propertyGroup.getCards().contains(card1));
    }

    @Test
    void testGetName() {
        assertEquals("Test Group", propertyGroup.getName());
    }

    @Test
    void testGetCards() {
        propertyGroup.addCard(card1);
        propertyGroup.addCard(card2);
        HashSet<Card> expectedCards = new HashSet<>();
        expectedCards.add(card1);
        expectedCards.add(card2);
        assertEquals(expectedCards, propertyGroup.getCards());
    }
}

