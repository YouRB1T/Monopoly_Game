package roles;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.CardAction;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.roles.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    private Card pricedCard;
    private Card nonPricedCard;

    @BeforeEach
    void setUp() {
        player = new Player("Test Player");
        pricedCard = new PropertyCard(100);
        nonPricedCard = new CardAction();
    }

    @Test
    void testInitialMoney() {
        assertEquals(0, player.getMoneys());
        assertEquals(0, player.getTotalMoneys());
    }

    @Test
    void testAddMoney() {
        player.addMoneys(50);
        assertEquals(50, player.getMoneys());
        assertEquals(50, player.getTotalMoneys());
    }

    @Test
    void testSubMoney() {
        player.addMoneys(100);
        player.subMoneys(30);
        assertEquals(70, player.getMoneys());
        assertEquals(70, player.getTotalMoneys());
    }

    @Test
    void testAddCard() {
        player.addCard(pricedCard);
        assertTrue(player.hasCard(pricedCard));
        assertEquals(100, player.getTotalMoneys());
    }

    @Test
    void testDeleteCard() {
        player.addCard(pricedCard);
        player.deleteCard(pricedCard);
        assertFalse(player.hasCard(pricedCard));
        assertEquals(0, player.getTotalMoneys());
    }

    @Test
    void testAddNonPricedCard() {
        player.addCard(nonPricedCard);
        assertTrue(player.hasCard(nonPricedCard));
        assertEquals(0, player.getTotalMoneys());
    }

    @Test
    void testSubMoneyBelowZero() {
        player.addMoneys(50);
        player.subMoneys(100);
        assertEquals(-50, player.getMoneys());
        assertEquals(-50, player.getTotalMoneys());
    }
}
