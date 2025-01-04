package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.roles.Player;

import java.util.List;

public class StartGameEvent extends Event{

    public StartGameEvent() {
    }

    @Override
    public void execute(Player player, Board board) {

    }

    public void executeStart(List<Player> players, Integer sumForStart) {
        players.forEach(p -> {
            p.addMoneys(sumForStart);
        });
    }
}
