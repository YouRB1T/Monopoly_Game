package monopoly.entity.cards.properties;

import lombok.Getter;
import lombok.Setter;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.events.board.EventOnBoard;
import monopoly.entity.roles.Player;

@Getter
@Setter
public class PropertyCard extends Card implements Priced {
    private final Integer price;
    private final Rent rent;
    private Integer currLevel;
    private Player owner;

    public PropertyCard(EventOnBoard eventOfCard, String title, String description, Integer price, Rent rent) {
        super(eventOfCard, title, description);
        this.price = price;
        this.rent = rent;
    }

    @Override
    public Integer getPrice() {
        return price;
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
