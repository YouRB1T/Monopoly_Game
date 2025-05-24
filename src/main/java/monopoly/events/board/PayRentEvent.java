package monopoly.events.board;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.cards.properties.characteristics.Rent;
import monopoly.entity.roles.Player;

public class PayRentEvent extends EventOnBoard {

    public PayRentEvent(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Player player, Board board) {

        PropertyCard currentCard = (PropertyCard) board.getCard(
                board.getPlayerPosition(player)
        );
        Player owner = (Player) currentCard.getOwner();
        Rent currRent = currentCard.getRent();
        payRent(player, owner, currRent.getRentByLevel(currentCard.getCurrLevel()));

    }

    public void payRent(Player playerNotOwner, Player owner, Integer rent) {
        playerNotOwner.subMoneys(rent);
        owner.addMoneys(rent);
    }

    @Override
    public String getDescription() {
        return "Pay Rent Event";
    }
}
