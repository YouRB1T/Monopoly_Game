package card.properties.characteristics;

import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.cards.properties.characteristics.RentUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class RentUtilsTest {

    private Rent rent;

    @BeforeEach
    public void setUp() {
        rent = new Rent(new HashMap<>());
    }

    @Test
    public void testFillRent() {
        RentUtils.fillRent(rent, 5);

        assertEquals(100, rent.getRentByLevel().get(1), "Rent for level 1 should be 100");
        assertEquals(200, rent.getRentByLevel().get(2), "Rent for level 2 should be 200");
        assertEquals(300, rent.getRentByLevel().get(3), "Rent for level 3 should be 300");
        assertEquals(400, rent.getRentByLevel().get(4), "Rent for level 4 should be 400");
        assertEquals(500, rent.getRentByLevel().get(5), "Rent for level 5 should be 500");
    }

    @Test
    public void testFillRentWithBasePrice() {
        RentUtils.fillRentWithBasePrice(rent, 5, 150);

        assertEquals(150, rent.getRentByLevel().get(1), "Rent for level 1 should be 150");
        assertEquals(300, rent.getRentByLevel().get(2), "Rent for level 2 should be 300");
        assertEquals(450, rent.getRentByLevel().get(3), "Rent for level 3 should be 450");
        assertEquals(600, rent.getRentByLevel().get(4), "Rent for level 4 should be 600");
        assertEquals(750, rent.getRentByLevel().get(5), "Rent for level 5 should be 750");
    }

    @Test
    public void testFillRentWithCustomCalculation() {
        RentUtils.fillRentWithCustomCalculation(rent, 5, level -> level * level * 50);

        assertEquals(50, rent.getRentByLevel().get(1), "Rent for level 1 should be 50");
        assertEquals(200, rent.getRentByLevel().get(2), "Rent for level 2 should be 200");
        assertEquals(450, rent.getRentByLevel().get(3), "Rent for level 3 should be 450");
        assertEquals(800, rent.getRentByLevel().get(4), "Rent for level 4 should be 800");
        assertEquals(1250, rent.getRentByLevel().get(5), "Rent for level 5 should be 1250");
    }

    @Test
    public void testFillTestRent() {
        RentUtils rentUtils = new RentUtils();
        rentUtils.fillTestRent(rent);

        assertEquals(100, rent.getRentByLevel().get(1), "Rent for level 1 should be 100");
        assertEquals(200, rent.getRentByLevel().get(2), "Rent for level 2 should be 200");
        assertEquals(300, rent.getRentByLevel().get(3), "Rent for level 3 should be 300");
        assertEquals(400, rent.getRentByLevel().get(4), "Rent for level 4 should be 400");
        assertEquals(500, rent.getRentByLevel().get(5), "Rent for level 5 should be 500");
    }
}
