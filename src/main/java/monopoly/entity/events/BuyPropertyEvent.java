package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.roles.Player;

public class BuyPropertyEvent extends Event{
    @Override
    public void execute(Player player, Board board) {
        Integer currentPosition = board.getPlayerPosition(player);
        PropertyCard currentCard = (PropertyCard) board.getCard(currentPosition);
        player.addCard(currentCard);
        board.setPlayerCard(currentPosition, player);
        player.subMoneys(currentCard.getPrice());
    }
}
