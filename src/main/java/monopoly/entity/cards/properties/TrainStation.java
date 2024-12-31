package monopoly.entity.cards.properties;

import monopoly.entity.cards.Card;
import monopoly.entity.events.Event;

public class TrainStation extends Card {
    private Integer price;

    public TrainStation(Event eventOfCard, String title, String description,
                        Integer price) {
        super(eventOfCard, title, description);
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
