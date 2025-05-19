package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class EndGameEvent extends Event{

    public EndGameEvent(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(Player player, Board board) {

    }

    public Player executeEnd(List<Player> players) {
        AtomicReference<Player> winner = new AtomicReference<>(new Player());

        players.forEach(p -> {
            if (p.getTotalMoneys() > winner.get().getTotalMoneys()) {
                winner.set(p);
            }
        });
        return winner.get();
    }
}
