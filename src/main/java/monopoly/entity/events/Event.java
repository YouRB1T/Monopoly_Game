package monopoly.entity.events;

import lombok.*;
import monopoly.entity.Board;
import monopoly.entity.cards.Card;
import monopoly.entity.roles.Player;

@Getter
@Setter
@AllArgsConstructor
public abstract class Event {
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
