package builders;

import monopoly.builders.ClassicGameBuilder;
import monopoly.entity.cards.StartCard;
import monopoly.entity.cards.properties.PropertyCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyGroup;

import java.util.List;

class ClassicGameBuilderTest {
    private Board board;
    private ClassicGameBuilder gameBuilder;

    @BeforeEach
    void setUp() {
        gameBuilder = new ClassicGameBuilder();
        board = gameBuilder.getBoard();
    }

    @Test
    void testConstructBoard() {
        gameBuilder.constructBoard();


        assertNotNull(board.getCard(1));
        assertTrue(board.getCard(1) instanceof StartCard);


        for (int i = 2; i < 2 + gameBuilder.getPropertyGroups().length; i++) {
            assertNotNull(board.getCard(i));
            assertTrue(board.getCard(i) instanceof PropertyCard);
        }
    }

    @Test
    void testPropertyGroups() {
        gameBuilder.constructBoard();
        PropertyGroup[] propertyGroups = gameBuilder.getPropertyGroups();


        assertEquals(7, propertyGroups.length);
        assertEquals("Коричневые", propertyGroups[0].getName());
        assertEquals("Синие", propertyGroups[6].getName());


        for (PropertyGroup group : propertyGroups) {
            assertFalse(group.getCards().isEmpty());
        }
    }

    @Test
    void testGetTitles() {
        String[] titles = gameBuilder.getTitles();
        assertEquals(7, titles.length);
        assertEquals("Нагатинская", titles[0]);
        assertEquals("Арбат", titles[6]);
    }

    @Test
    void testGetBoard() {
        assertEquals(board, gameBuilder.getBoard());
    }
}
