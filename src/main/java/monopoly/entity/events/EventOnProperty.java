package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.properties.PropertyCard;
import monopoly.entity.roles.Player;

public class EventOnProperty extends Event{
    private final PayRentEvent payRentEvent;
    private final BuyPropertyEvent buyPropertyEvent;
    private final ChooseEvent chooseEvent;

    public EventOnProperty(String description,
                           PayRentEvent payRentEvent, BuyPropertyEvent buyPropertyEvent, ChooseEvent chooseEvent)
    {
        super(description);
        this.payRentEvent = payRentEvent;
        this.buyPropertyEvent = buyPropertyEvent;
        this.chooseEvent = chooseEvent;
    }

    @Override
    public void execute(Player player, Board board) {
        if (board.isFreeCard(board.getPlayerPosition(player))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Would you like to buy this property? Prise of property: ")
                    .append(
                            (
                            (PropertyCard) board.getCard(board.getPlayerPosition(player))
                            )
                                    .getPrice());

            if (chooseEvent.choose(stringBuilder.toString())) {
                buyPropertyEvent.execute(player, board);
            }
        } else {
            payRentEvent.execute(player, board);
        }
    }
}
