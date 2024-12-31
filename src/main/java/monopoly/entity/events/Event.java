package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.roles.Player;

public abstract class Event {
    private String description;

    public Event() {
    }

    public Event(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(Player player, Board board);

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                '}';
    }
}
