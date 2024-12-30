package monopoly.entity.events;

import monopoly.entity.Board;
import monopoly.entity.Player;

public abstract class Event {
    private String description;

    public Event(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void execute(Player player, Board board) {

    }

}
