package monopoly.entity.cards.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.cards.properties.characteristics.RentUtils;
import monopoly.entity.events.Event;
import monopoly.entity.roles.Role;

@Getter
@Setter
@RequiredArgsConstructor
public class PropertyCard extends Card implements Priced {
    private final Integer price;
    private final Rent rent;
    private Integer currLevel;
    private Role owner;

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
