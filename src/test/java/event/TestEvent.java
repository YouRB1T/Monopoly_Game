package event;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;
import monopoly.entity.events.Event;

public class TestEvent extends Event {

    public TestEvent() {
    }

    public TestEvent(String description) {
        super(description);
    }

    @Override
    public void execute(Player player) {
        // Реализация метода для тестирования
    }
}
