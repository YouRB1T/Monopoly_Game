package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.roles.Player;

public class PlayerMoveEvent extends Event{
    private final RollDiceEvent rollDiceEvent;

    public PlayerMoveEvent() {
        rollDiceEvent = new RollDiceEvent();

    }

    @Override
    public void execute(Player player, Board board) {
        int nextPlayerPosition = nextPosition(board.getPlayerPosition(player),
                rollDiceEvent.rollDeices(), board.getMaxSize());
        Card nextPlayerCard = board.getCard(nextPlayerPosition);

        board.setPlayerPosition(nextPlayerPosition, player);

        nextPlayerCard.getEventOfCard().execute(player, board);
    }


    private int nextPosition(int playerPosition, int diceResult, int sizeBoard) {
        return playerPosition + diceResult <= sizeBoard ?
                playerPosition + diceResult : playerPosition + diceResult - sizeBoard;

    }

}
