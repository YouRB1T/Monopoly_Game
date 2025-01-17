package card.properties.characteristics;

import monopoly.entity.cards.properties.characteristics.Rent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RentTest {

    private Rent rent;

    @BeforeEach
    public void setUp() {
        rent = new Rent(new HashMap<>());
    }

    @Test
    public void testSetRentOnNewLevel() {
        rent.setRentOnTheLevel(1, 100);
        assertEquals(100, rent.getRentByLevel().get(1), "Rent for level 1 should be 100");
    }

    @Test
    public void testSetRentOnExistingLevel() {
        rent.setRentOnTheLevel(1, 100);
        rent.setRentOnTheLevel(1, 150);
        assertEquals(150, rent.getRentByLevel().get(1), "Rent for level 1 should be updated to 150");
    }

    @Test
    public void testSetRentOnMultipleLevels() {

        rent.setRentOnTheLevel(1, 100);
        rent.setRentOnTheLevel(2, 200);
        rent.setRentOnTheLevel(3, 300);

        assertEquals(100, rent.getRentByLevel().get(1), "Rent for level 1 should be 100");
        assertEquals(200, rent.getRentByLevel().get(2), "Rent for level 2 should be 200");
        assertEquals(300, rent.getRentByLevel().get(3), "Rent for level 3 should be 300");
    }

    @Test
    public void testSetRentOnLevelWithNegativeValue() {
        rent.setRentOnTheLevel(1, -50);
        assertEquals(-50, rent.getRentByLevel().get(1), "Rent for level 1 should be -50");
    }

    @Test
    public void testSetRentOnLevelWithZeroValue() {
        rent.setRentOnTheLevel(1, 0);
        assertEquals(0, rent.getRentByLevel().get(1), "Rent for level 1 should be 0");
    }
}

