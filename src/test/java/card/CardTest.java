package card;

import event.TestEvent;
import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    private TestCard card;

    @BeforeEach
    public void setUp() {
        card = new TestCard("Test Title", "Test Description");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Title", card.getTitle());
    }

    @Test
    public void testSetTitle() {
        card.setTitle("New Title");
        assertEquals("New Title", card.getTitle());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Test Description", card.getDescription());
    }

    @Test
    public void testSetDescription() {
        card.setDescription("New Description");
        assertEquals("New Description", card.getDescription());
    }

    @Test
    public void testGetEventOfCard() {
        TestEvent event = new TestEvent();
        card.setEventOfCard(event);
        assertEquals(event, card.getEventOfCard());
    }

    @Test
    public void testSetEventOfCard() {
        TestEvent event = new TestEvent();
        card.setEventOfCard(event);
        assertEquals(event, card.getEventOfCard());
    }

    @Test
    public void testExecuteAction() {
        Player player = new Player();
        Board board = new Board();
        card.executeActon(player, board);
    }
}

