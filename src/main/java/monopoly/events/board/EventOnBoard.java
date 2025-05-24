package monopoly.events.board;

import lombok.*;
import monopoly.entity.Board;
import monopoly.events.Event;
import monopoly.entity.roles.Player;

@Getter
@Setter
@AllArgsConstructor
public abstract class EventOnBoard implements Event {
    private String name;
    private String description;

    public abstract void execute(Player player, Board board);

    @Override
    public String toString() {
        return "Event{" +
                "description='" + description + '\'' +
                '}';
    }
}
