import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.PropertyGroup;
import monopoly.entity.roles.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class BoardTest {
    private Board board;
    private Card card1;
    private Card card2;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        board = new Board();
        card1 = new PropertyCard("Property 1", 200);
        card2 = new PropertyCard("Property 2", 300);
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    @Test
    void testAddCard() {
        board.addCard(1, card1);
        assertEquals(card1, board.getCard(1));
        assertEquals(1, board.getMaxSize());

        board.addCard(2, card2);
        assertEquals(card2, board.getCard(2));
        assertEquals(2, board.getMaxSize());
    }

    @Test
    void testGetCard() {
        board.addCard(1, card1);
        assertEquals(card1, board.getCard(1));
        assertNull(board.getCard(2));
    }

    @Test
    void testSetPlayerPosition() {
        board.setPlayerPosition(0, player1);
        assertEquals(0, board.getPlayerPosition(player1));

        board.setPlayerPosition(1, player1);
        assertEquals(1, board.getPlayerPosition(player1));
    }

    @Test
    void testSetPlayerCard() {
        board.setPlayerCard(1, player1);
        assertEquals(player1, board.getPlayersCards().get(1));

        board.setPlayerCard(2, player2);
        assertEquals(player2, board.getPlayersCards().get(2));
    }

    @Test
    void testIsFreeCard() {
        board.addCard(1, card1);
        assertTrue(board.isFreeCard(2));
        board.setPlayerCard(1, player1);
        assertFalse(board.isFreeCard(1));
    }

    @Test
    void testGetPlayerPosition() {
        board.setPlayerPosition(3, player1);
        assertEquals(3, board.getPlayerPosition(player1));
        assertNull(board.getPlayerPosition(player2));
    }

    @Test
    void testSetPropertyGroups() {
        List<PropertyGroup> propertyGroups = new ArrayList<>();
        propertyGroups.add(new PropertyGroup("Group 1"));
        board.setPropertyGroups(propertyGroups);
        assertEquals(propertyGroups, board.getPropertyGroups());
    }
}

