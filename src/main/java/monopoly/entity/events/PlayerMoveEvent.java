package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.roles.Player;

import java.util.Random;

public class PlayerMoveEvent extends Event{
    private final RollDiceEvent rollDiceEvent;

    public PlayerMoveEvent() {
        rollDiceEvent = new RollDiceEvent(new Random());

    }

    @Override
    public void execute(Player player, Board board) {
        int nextPlayerPosition = nextPosition(board.getPlayerPosition(player),
                rollDiceEvent.rollDice(), board.getMaxSize());

        System.out.println(nextPlayerPosition);
        Card nextPlayerCard = board.getCard(nextPlayerPosition);

        board.setPlayerPosition(nextPlayerPosition, player);

        nextPlayerCard.getEventOfCard().execute(player, board);
    }

    private int nextPosition(int playerPosition, int diceResult, int sizeBoard) {
        if (sizeBoard <= 0) {
            throw new IllegalArgumentException("Размер доски должен быть больше нуля.");
        }

        if (sizeBoard == 1) {
            return 1;
        }

        System.out.println(playerPosition + " " + diceResult + " " + sizeBoard);
        return (playerPosition + diceResult) % sizeBoard + 1;
    }

}
