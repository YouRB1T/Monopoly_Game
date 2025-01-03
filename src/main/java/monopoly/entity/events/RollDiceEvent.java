package monopoly.entity.events;

import monopoly.entity.roles.Player;

public class RollDiceEvent extends Event {
    @Override
    public void execute(Player player) {

    }

    public int rollDeices(){
        return 9;
    }
}
