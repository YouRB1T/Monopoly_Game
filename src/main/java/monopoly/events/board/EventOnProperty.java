package monopoly.events.board;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.roles.Player;


public class EventOnProperty extends EventOnBoard{
    private final BuyPropertyEvent buyPropertyEvent = new BuyPropertyEvent("Покупка собственности",
            "Сработал ивент покупки собственности");
    private final PayRentEvent payRentEvent = new PayRentEvent("Оплата аренды",
            "Сработал ивент оплаты аренды");

    public EventOnProperty(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Player player, Board board) {
        Player owner = board.getPropertyOwner((PropertyCard) board.getPlayerPositionCard(player));
        if (owner != null) {
            payRentEvent.execute(player, board);
        } else {
            buyPropertyEvent.execute(player, board);
        }
    }
}
