package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.roles.Player;

public class PayRentEvent extends Event {

    public PayRentEvent() {
        super();
    }

    public PayRentEvent(String description) {
        super(description);
    }

    @Override
    public void execute(Player player, Board board) {

        PropertyCard currentCard = (PropertyCard) board.getCard(
                board.getPlayerPosition(player)
        );

        Rent currRent = currentCard.getRent();
        payRent(player, currRent.getRentByLevel(currentCard.getCurrLevel()));

    }

    public void payRent(Player player, Integer rent) {
        player.subMoneys(rent);
    }

    @Override
    public String getDescription() {
        return "Pay Rent Event";
    }
}
