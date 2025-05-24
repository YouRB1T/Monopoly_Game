package monopoly.entity.cards.properties;

import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.events.board.EventOnBoard;

public class TrainStation extends PropertyCard {
    public TrainStation(EventOnBoard eventOfCard, String title, String description, Integer price, Rent rent) {
        super(eventOfCard, title, description, price, rent);
    }
}
