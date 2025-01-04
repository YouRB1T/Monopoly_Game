package monopoly.entity.cards.properties;

import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.events.Event;

public class PropertyCard extends Card implements Priced {
    private Integer price;
    private Rent rent;
    private Integer currLevel;

    public PropertyCard() {
    }

    public PropertyCard(Event eventOfCard, String title, String description) {
        super(eventOfCard, title, description);
    }

    public PropertyCard(String title, String description) {
        super(title, description);
    }

    public PropertyCard(Event eventOfCard, String title, String description,
                        Integer price, Rent rent, Integer currLevel) {
        super(eventOfCard, title, description);
        this.price = price;
        this.rent = rent;
        this.currLevel = currLevel;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Integer getCurrLevel() {
        return currLevel;
    }

    public void setCurrLevel(Integer currLevel) {
        this.currLevel = currLevel;
    }

    @Override
    public String toString() {
        return "PropertyCard{" +
                "event=" + super.getEventOfCard() +
                "title=" + super.getTitle() +
                "description=" + super.getDescription() +
                "price=" + price +
                ", rent=" + rent.toString() +
                ", currLevel=" + currLevel +
                '}';
    }
}
