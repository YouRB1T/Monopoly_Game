package card.properties;

import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.cards.properties.characteristics.RentUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyCardTest {

    private PropertyCard propertyCard;
    private Rent rent;

    @BeforeEach
    public void setUp() {
        rent = new Rent();
        RentUtils.fillRent(rent, 5);

        propertyCard = new PropertyCard(null, "Test Property", "Test Description", 1000, rent, 1);
    }

    @Test
    public void testGetPrice() {
        assertEquals(1000, propertyCard.getPrice(), "Price should be 1000");
    }

    @Test
    public void testSetPrice() {
        propertyCard.setPrice(1200);
        assertEquals(1200, propertyCard.getPrice(), "Price should be updated to 1200");
    }

    @Test
    public void testGetRent() {
        assertEquals(rent, propertyCard.getRent(), "Rent should match the initialized rent object");
    }

    @Test
    public void testSetRent() {
        Rent newRent = new Rent();
        RentUtils.fillRent(newRent, 3);
        propertyCard.setRent(newRent);
        assertEquals(newRent, propertyCard.getRent(), "Rent should be updated to the new rent object");
    }

    @Test
    public void testGetCurrLevel() {
        assertEquals(1, propertyCard.getCurrLevel(), "Current level should be 1");
    }

    @Test
    public void testSetCurrLevel() {
        propertyCard.setCurrLevel(2);
        assertEquals(2, propertyCard.getCurrLevel(), "Current level should be updated to 2");
    }
}

