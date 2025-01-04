package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;

public class RollDiceEvent extends Event {
    @Override
    public void execute(Player player, Board board) {

    }

    public int rollDeices(){
        return 9;
    }
}
