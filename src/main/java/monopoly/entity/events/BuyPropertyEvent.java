package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.roles.Player;

public class BuyPropertyEvent extends Event{
    public BuyPropertyEvent(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Player player, Board board) {
        Integer currentPosition = board.getPlayerPosition(player);
        PropertyCard currentCard = (PropertyCard) board.getCard(currentPosition);
        player.addCard(currentCard);
        player.buyCard(currentCard.getPrice());
        currentCard.setOwner(player);
        board.setPropertyOwner(currentCard, player);
    }
}
