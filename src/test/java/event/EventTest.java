package event;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    private TestEvent event;

    @BeforeEach
    public void setUp() {
        event = new TestEvent("Test Event Description");
    }

    @Test
    public void testGetDescription() {
        assertEquals("Test Event Description", event.getDescription());
    }

    @Test
    public void testSetDescription() {
        event.setDescription("New Event Description");
        assertEquals("New Event Description", event.getDescription());
    }

    @Test
    public void testExecute() {
        Player player = new Player();

        event.execute(player);
    }
}
