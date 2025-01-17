package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;

import java.util.Random;

public class RollDiceEvent {
    private final Random random;

    public RollDiceEvent(Random random) {
        this.random = random;
    }

    public int rollDice() {
        return random.nextInt(12) + 1;
    }
}
