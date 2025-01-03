package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.roles.Player;

public class PlayerMoveEvent extends Event{
    private RollDiceEvent rollDiceEvent;

    public PlayerMoveEvent() {
        rollDiceEvent = new RollDiceEvent();

    }
    @Override
    public void execute(Player player) {

    }

    public void executeOnBoard(Player player, Board<Card> board) {
        int dicesResult = rollDiceEvent.rollDeices();

    }

}
